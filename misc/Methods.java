class Methods {

    //try to make a generic method for any type at some point
    // make2DArray method overloading for primitive types begins here
    
    public static int[][] make2DArray(int rowLength, int[] data) {
        if (data.length == 0) {
            return new int[][] { new int[] {} };
        }
        
        int[][] newData = new int[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            int[] row = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static long[][] make2DArray(int rowLength, long[] data) {
        if (data.length == 0) {
            return new long[][] { new long[] {} };
        }
        
        long[][] newData = new long[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            long[] row = new long[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static short[][] make2DArray(int rowLength, short[] data) {
        if (data.length == 0) {
            return new short[][] { new short[] {} };
        }
        
        short[][] newData = new short[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            short[] row = new short[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static byte[][] make2DArray(int rowLength, byte[] data) {
        if (data.length == 0) {
            return new byte[][] { new byte[] {} };
        }
        
        byte[][] newData = new byte[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            byte[] row = new byte[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static char[][] make2DArray(int rowLength, char[] data) {
        if (data.length == 0) {
            return new char[][] { new char[] {} };
        }
        
        char[][] newData = new char[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            char[] row = new char[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static boolean[][] make2DArray(int rowLength, boolean[] data) {
        if (data.length == 0) {
            return new boolean[][] { new boolean[] {} };
        }
        
        boolean[][] newData = new boolean[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            boolean[] row = new boolean[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static float[][] make2DArray(int rowLength, float[] data) {
        if (data.length == 0) {
            return new float[][] { new float[] {} };
        }
        
        float[][] newData = new float[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            float[] row = new float[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    public static double[][] make2DArray(int rowLength, double[] data) {
        if (data.length == 0) {
            return new double[][] { new double[] {} };
        }
        
        double[][] newData = new double[data.length / rowLength][rowLength];
        for (int i = 0; i < data.length / rowLength; i++) {
            double[] row = new double[rowLength];
            for (int j = 0; j < rowLength; j++) {
                row[j] = data[i * rowLength + j];
            }
            newData[i] = row;
        }
        return newData;
    }

    // make2DArray method overloading for primitives ends here
}