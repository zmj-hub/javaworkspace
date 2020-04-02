package IsolationForest;

import org.ejml.data.DenseMatrix64F;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IsoForest {

    public DenseMatrix64F loadFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = null;

        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        int col = lines.get(0).split(",").length - 1;
        DenseMatrix64F data = new DenseMatrix64F(lines.size(), col);

        for (int i = 0; i < lines.size(); i++) {
            String[] strings = lines.get(i).split(",");
            for (int j = 0; j < col; j++) {
                data.set(i, j, Double.parseDouble(strings[j]));
            }
        }

        return data;
    }

    public DenseMatrix64F getSubSample(DenseMatrix64F dataSet, int subSampleCount) {
        int features = dataSet.numCols;
        DenseMatrix64F subSample = new DenseMatrix64F(subSampleCount, features);

        for (int i = 0; i < subSampleCount; i++) {
            for (int j = 0; j < features; j++) {
                subSample.set(i, j, dataSet.get(i, j));
            }
        }

        return subSample;
    }

    public IForest train(String filepath) throws IOException {
        DenseMatrix64F dataSet = loadFile(filepath);
        int rows = dataSet.numRows;

        int maxLength = (int) Math.ceil(bottomChanging(rows, 2));
        int numTrees = 10;
        int numFeatures = dataSet.numCols;
        int maxSamples = 256;
        int subSampleSize = Math.min(256, rows);

        List<ITree> iTrees = new ArrayList<ITree>();

        for (int i = 0; i < numTrees; i++) {
            DenseMatrix64F subSample = getSubSample(dataSet, subSampleSize);
            ITree iTree = growTree(subSample, maxLength, numFeatures, 0);
            iTrees.add(iTree);
        }

        return new IForest(iTrees, maxSamples);

    }

    public ITree growTree(DenseMatrix64F data, int maxLength, int numFeatures, int currentLength) {
        if (currentLength >= maxLength || data.numRows <= 1) {
            return new ITreeLeaf(data.numRows);
        }

        Random random = new Random();
        int feature = random.nextInt(numFeatures);
        int rows = data.numRows;
        int randomRow = random.nextInt(rows);
        double splitPoint = data.get(randomRow, feature);

        List<Integer> rightList = new ArrayList<Integer>();
        List<Integer> leftList = new ArrayList<Integer>();
        for (int i = 0; i < rows; i++) {
            if (data.get(i, feature) >= splitPoint) {
                rightList.add(i);
            } else {
                leftList.add(i);
            }
        }

        DenseMatrix64F left = new DenseMatrix64F(leftList.size(), numFeatures);
        DenseMatrix64F right = new DenseMatrix64F(rightList.size(), numFeatures);

        for (int i = 0; i < leftList.size(); i++) {
            for (int j = 0; j < numFeatures; j++) {
                left.set(i, j, data.get(i, j));
            }
        }

        for (int i = 0; i < rightList.size(); i++) {
            for (int j = 0; j < numFeatures; j++) {
                right.set(i, j, data.get(i, j));
            }
        }

        return new ITreeBranch(growTree(left, maxLength, numFeatures, currentLength + 1), growTree(right, maxLength, numFeatures, currentLength + 1),
                splitPoint, feature);

    }

    public double bottomChanging(int x, int bottom) {
        double log = Math.log10(x) / Math.log10(bottom);
        return log;
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        long start = System.currentTimeMillis();
        while (count < 20) {
            String filepath = "C:\\Users\\zhang\\Desktop\\waterData(1)\\waterData\\trainForIsoForest.txt";
            IsoForest isoForest = new IsoForest();
            IForest forest = isoForest.train(filepath);


            String testPath = "C:\\Users\\zhang\\Desktop\\waterData(1)\\waterData\\testForIsoForest.txt";
            double accurate = forest.getAccurate(testPath);
            System.out.println("accurate is " + accurate);
            count++;
        }

        long elapse = System.currentTimeMillis() - start;
        System.out.println("花费时间" + elapse / 1000.0 + "s");

    }

}
