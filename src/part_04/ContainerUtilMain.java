package part_04;

public class ContainerUtilMain {
    public static void main(String[] args) {
        Integer[] intArray = {2,3,4,6,7,8,1,4,9};
        String[] strArray = {"a","b","c","d"};
        int intMax = ContainerUtil.findMax(intArray);
        String strMax = ContainerUtil.findMax(strArray);
        System.out.println(intMax);
        System.out.println(strMax);

        ContainerUtil.swapElements(intArray, 0, 1);

        String[] convertStrArray = ContainerUtil.convertArray(intArray, String::valueOf, String.class);
        for (String str:convertStrArray) {
            System.out.print(str + "\t");
        }

    }
}
