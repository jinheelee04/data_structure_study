package list.linkedlist.implementation;


public class Main {
    public static void main(String[] args){
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);

        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());

        numbers.addFirst(5);
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());

        System.out.println("remove data : "+numbers.removeFirst());
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());

        System.out.println("remove data : "+numbers.remove(2));
        System.out.println(numbers);
        System.out.println("size : "+ numbers.size());
        
        System.out.println("첫 번째 요소 : "+numbers.get(0));
        System.out.println("두 번째 요소 : "+numbers.get(1));

        LinkedList.ListIterator li = numbers.listIterator();
        System.out.println("iterator 1 : "+li.next());
        System.out.println("iterator 2 : "+li.next());

        LinkedList.ListIterator li2 = numbers.listIterator();
        while(li2.hasNext()){
            System.out.println("has next test : "+li2.next());
        }

    }
}
