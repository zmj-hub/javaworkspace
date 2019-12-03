import java.util.Scanner;

public class TestJsonArray {
    private static int N;//保存顶点个数
    private static int M;//保存边个数
    private static int max;//用来设定一个比所有边的权都大的值，来表示两点间没有连线
    private static int[] visit;//找到一个顶点的最短距离，就把它设为1，默认为0（即还没有找到）
    private static int[][] distance;//保存图中个边的值，两点间无边则设为max
    private static int[] bestmin;//保存源点到其他各点的最短距离，用于最后输出
    private static String[] path; //有些题目会要求输出路径，保存输出路径

    public static void Dijkstra() {
        visit[1] = 1;
        bestmin[1] = 0;

        //大循环（搞定这里就算搞定该算法了，后面的输出什么的可以不看）
        for(int l = 2; l <= N; l++) {
            int Dtemp = max;
            int k = -1;

            //步骤①
            for(int i = 2; i <= N; i++) {
                if(visit[i] == 0 && distance[1][i] < Dtemp) {
                    Dtemp = distance[1][i];
                    k = i;
                }
            }
            visit[k] = 1;
            bestmin[k] = Dtemp;

            //步骤②
            for(int i = 2; i <= N; i++) {
                if(visit[i] == 0 && (distance[1][k] + distance[k][i]) < distance[1][i]) {
                    distance[1][i] = distance[1][k] + distance[k][i];
                    path[i] = path[k] + "-->" + i;
                }
            }
        }

        //输出路径
        for(int i=1;i<=N;i++) {
            System.out.println("从"+1+"出发到"+i+"的最短路径为："+path[i]);
        }
        System.out.println("=====================================");
        for(int i = 1; i <= N; i++) {
            System.out.println("从1出发到" + i + "点的最短距离为：" + bestmin[i]);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        System.out.print("请输入节点个数N，路径总数M： ");
        N = input.nextInt();
        M = input.nextInt();
        max = 10000;
        bestmin = new int[N+1];
        distance = new int [N+1][N+1];
        visit = new int[N+1];
        path=new String[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                }else {
                    distance[i][j] = max;
                }
            }
            bestmin[i] = max;
            path[i] = new String("1-->" + i);
        }

        System.out.println("请输入" + M +"条数据x，y，z（表示x点到y点的距离为z）：");
        for(int i = 1; i <= M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            distance[x][y] = z;
        }
        input.close();

        Dijkstra();
    }
}
