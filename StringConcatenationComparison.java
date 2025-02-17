public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] operationCounts = {1000, 10000, 1000000};
        for (int count : operationCounts) {
            String[] strings = new String[count];
            for (int i = 0; i < count; i++) {
                strings[i] = "string" + i;
            }
            long startTime = System.nanoTime();
            concatWithString(strings);
            long stringTime = System.nanoTime() - startTime;
            startTime = System.nanoTime();
            concatWithStringBuilder(strings);
            long stringBuilderTime = System.nanoTime() - startTime;
            startTime = System.nanoTime();
            concatWithStringBuffer(strings);
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("Operation count: " + count);
            System.out.println("String Concatenation Time: " + stringTime / 1000000.0 + "ms");
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1000000.0 + "ms");
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1000000.0 + "ms");
            System.out.println();
        }
    }
    public static void concatWithString(String[] strings) {
        String result = "";
        for (String str : strings) {
            result += str;
        }
    }
    public static void concatWithStringBuilder(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
    }
    public static void concatWithStringBuffer(String[] strings) {
        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
        }
    }
}
