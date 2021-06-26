package list.linkedlist.implementation;


public class Main {
    public static void main(String[] args){
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);

        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());
        System.out.println("--------------------------------");
        numbers.addFirst(5);
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());
        System.out.println("--------------------------------");
        System.out.println("remove first data : "+numbers.removeFirst());
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());
        System.out.println("--------------------------------");
        System.out.println("remove data : "+numbers.remove(2));
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());
        System.out.println("--------------------------------");
        System.out.println("첫 번째 요소 : "+numbers.get(0));
        System.out.println("두 번째 요소 : "+numbers.get(1));
        System.out.println("--------------------------------");
        numbers.addLast(30);
        System.out.println("10의 인덱스 : "+numbers.indexOf(10));
        System.out.println("20의 인덱스 : "+numbers.indexOf(20));
        System.out.println("30의 인덱스 : "+numbers.indexOf(30));
        System.out.println("40의 인덱스 : "+numbers.indexOf(40));
        System.out.println("--------------------------------");
        LinkedList.ListIterator li = numbers.listIterator();
        System.out.println("iterator 1 : "+li.next());
        System.out.println("iterator 2 : "+li.next());
        System.out.println("iterator 3 : "+li.next());
        System.out.println("--------------------------------");
        LinkedList.ListIterator li2 = numbers.listIterator();
        while(li2.hasNext()){
            System.out.println("has next test : "+li2.next());
        }
        System.out.println("--------------------------------");
        LinkedList.ListIterator li3 = numbers.listIterator();

        while(li3.hasNext()){
            if((int)li3.next() == 10)
                li3.add(40);
        }

        System.out.println(numbers);
        System.out.println("--------------------------------");
        LinkedList.ListIterator li4 = numbers.listIterator();
        while(li4.hasNext()){
            if((int)li4.next() == 40)
                li4.remove();
        }
        System.out.println(numbers);


    }
}
