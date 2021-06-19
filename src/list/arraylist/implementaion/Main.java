package list.arraylist.implementaion;

public class Main {
    public static void main(String[] args){
        ArrayList numbers= new ArrayList();

        System.out.println("--- #1 데이터 추가 ");
        System.out.println(numbers);
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        System.out.println(numbers); // [10, 20, 30, 40]
        System.out.println("--------------------------------");

        System.out.println("--- #2 지정한 위치에 데이터 추가");
        numbers.add(1, 15);
        System.out.println(numbers); // [10, 15, 20, 30, 40]
        System.out.println("--------------------------------");

        System.out.println("--- #3 첫 번째 위치에 데이터 추가");
        numbers.addFirst(5);
        System.out.println(numbers); // [5, 10, 15, 20, 30, 40]
        System.out.println("--------------------------------");

        System.out.println("--- #4 지정한 위치에 데이터 삭제");
        System.out.println(numbers.remove(1)); // 10
        System.out.println(numbers); //[5, 15, 20, 30, 40]
        System.out.println("--------------------------------");

        System.out.println("--- #5 첫 번째 데이터 삭제");
        System.out.println(numbers.removeFirst()); // 5
        System.out.println(numbers);// [15, 20, 30, 40]
        System.out.println("--------------------------------");

        System.out.println("--- #6 마지막 데이터 삭제");
        System.out.println(numbers.removeLast()); // 40
        System.out.println(numbers); // [15, 20, 30]
        System.out.println("--------------------------------");
    }
}
