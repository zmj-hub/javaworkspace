public class TestDecryption {

    public static void main(String[] args) throws Exception {
        System.out.println(sampleCodeEncryption("158359-ZK-5856","INSPECTION",1));
//        000000-3R5I20101

        System.out.println(sampleCodeDecryption("158359-8R3I794101").toString());

        System.out.println(sampleCodeEncryption("158359-8R3I794501"));
    }


    private static String sampleCodeEncryption(String oldCode, String type, int num) throws Exception {
        //初始化
        if (oldCode.charAt(oldCode.length() - 1) >= 'A' && oldCode.charAt(oldCode.length() - 1) <= 'Z')
            oldCode = oldCode.substring(0, oldCode.length() - 1);
        char[] newCode = new char[6];
        newCode[5] = '-';
        String key = "RX241";
        if (QualityControlSampleType.externalCodeType.get(type) == null)
            throw new RuntimeException();
        String[] oldCodes;
        if (oldCode.contains("_")) {
            oldCodes = oldCode.split("_");
        } else if (oldCode.contains("-")) {
            oldCodes = oldCode.split("-");
        } else {
            throw new RuntimeException();
        }
        //加密
        for (int i = 0; i < 2; i++) {
            char codeAt = oldCodes[1].charAt(i);
            char keyAt = key.charAt(i % 5);
            int offset = Math.abs(keyAt - 'A');
            char newChar = (char) (codeAt + offset + 1);
            if (newChar > 'Z')
                newChar = (char) ('A' - 'Z' - 1 + newChar);
            newCode[i] = newChar;
        }
        for (int i = 0; i < oldCodes[2].length(); i++) {
            char codeAt = oldCodes[2].charAt(i);
            char keyAt = key.charAt((i + 2) % 5);
            if (i == 3)
                keyAt = key.charAt(2);
            int offset = Math.abs(keyAt - '0');
            int newChar = (char) (codeAt - '0' + offset + 1);
            if (newChar > 9)
                newChar = newChar % 10;
            newCode[i + 2] = (char) (newChar + '0');
        }
        //切换顺序并组装
        String result = oldCodes[0] + "-" + newCode[2] + newCode[0] + newCode[3] + newCode[1] + newCode[4];
        if (newCode[5] != '-')
            result += newCode[5];
        result += String.format("%02d", (int) (Math.random() * 25) * 4 + QualityControlSampleType.externalCodeType.get(type));
        result += String.format("%02d", num);
        return result;
    }




    private static Decryption sampleCodeDecryption(String newCode) {
        //初始化
        String[] newCodes = newCode.split("-");
        char[] oldCode = new char[6];
        oldCode[0]=newCodes[1].charAt(1);
        oldCode[1]=newCodes[1].charAt(3);
        oldCode[2]=newCodes[1].charAt(0);
        oldCode[3]=newCodes[1].charAt(2);
        oldCode[4]=newCodes[1].charAt(4);
        oldCode[5] = '-';
        int num;
        String type;
        if (newCodes[1].length()==9){
            num = Integer.parseInt(newCodes[1].substring(7));
            type = QualityControlSampleType.getKey((Integer.valueOf(newCodes[1].substring(5,7)))%4);
        }else if(newCodes[1].length()==10){
            num = Integer.parseInt(newCodes[1].substring(8));
            type = QualityControlSampleType.getKey((Integer.valueOf(newCodes[1].substring(6,8)))%4);
            oldCode[5]=newCodes[1].charAt(5);
        }else {
            return null;
        }
        String key = "RX241";
        //解密
        for (int i = 0; i < 2; i++) {
            char codeAt = oldCode[i];
            char keyAt = key.charAt(i % 5);
            int offset = Math.abs(keyAt - 'A');
            char newChar = (char) (codeAt - offset - 1);
            if (newChar < 'A')
                newChar = (char) ('Z' - 'A' + 1 + newChar);
            oldCode[i] = newChar;
        }
        for (int i = 0; i < newCodes[1].length()-6; i++) {
            char codeAt = oldCode[i+2];
            char keyAt = key.charAt((i + 2) % 5);
            if (i == 3)
                keyAt = key.charAt(2);
            int offset = Math.abs(keyAt - '0');
            int newChar = codeAt - '0' - offset - 1;
            if (newChar < 0)
                newChar = newChar + 10;
            oldCode[i + 2] = (char) (newChar + '0');
        }
        //组装
        String result = newCodes[0] + "-" + oldCode[0] + oldCode[1]+"-" + oldCode[2] + oldCode[3] + oldCode[4];
        if (oldCode[5] != '-')
            result += oldCode[5];

        Decryption decryption = new Decryption();
        decryption.setOldCode(result);
        decryption.setType(type);
        return decryption;
    }

    public static String sampleCodeEncryption(String newCode) {
        String oldCode;
        String key = "RX241";
        String[] oldCodes = newCode.split("-");
        //解密
        oldCode = getChar(oldCodes[1].charAt(1), key.charAt(0)) + "";
        oldCode = oldCode + getChar(oldCodes[1].charAt(3), key.charAt(1));
        oldCode = oldCode + "-";
        oldCode = oldCode + getNum(oldCodes[1].charAt(0), key.charAt(2));
        oldCode = oldCode + getNum(oldCodes[1].charAt(2), key.charAt(3));
        oldCode = oldCode + getNum(oldCodes[1].charAt(4), key.charAt(4));
        if (oldCodes[1].length() == 10)
            oldCode = oldCode + getNum(oldCodes[1].charAt(5), key.charAt(2));
        return oldCodes[0] + "-" + oldCode;
    }

    public static char getChar(char c, char key) {
        int offset = Math.abs(key - 'A');
        char newChar = (char) (c - offset - 1);
        if (newChar < 'A')
            newChar = (char) (-'A' + 'Z' + 1 + newChar);
        return newChar;
    }

    public static int getNum(char n, char key) {
        int offset = Math.abs(key - '0');
        int newChar = (n - '0' - offset - 1);
        if (newChar < 0)
            newChar = newChar + 10;
        return (newChar);
    }

}
