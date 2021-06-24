package list.linkedlist.implementation;

import java.util.ListIterator;

public class LinkedList {
    // 첫 번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size =0;

    private class Node{
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        public Node(Object input){
            this.data = input;
            this.next = null;
        }
        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    /**
     * 시작에 데이터 추가
     * @param input
     */
    public void addFirst(Object input){
        // 1. 노드 생성
        Node newNode = new Node(input);
        // 2. 새로운 노드의  다음 노드로 헤드를 지정
        newNode.next = head;
        // 3. 헤드로 새로운 노드를 지정
        head = newNode;
        size++;
        if(head.next == null){
            tail = head;
        }
    }

    /**
     * 끝에 데이터 추가
     * @param input
     */
    public void addLast(Object input){
        // 노드 생성
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 첫 번째 노드를 추가하는 메소드 사용
        if(size==0){
            addFirst(input);
        } else{
            // 마지막 노드의 다음 노드로 생성한 노드를 지정
            tail.next = newNode;
            // 마지막 노드를 갱신
            tail = newNode;
            //엘리먼트의 개수를 1 증가 시킴
            size++;
        }
    }

    /**
     * 특정 위치의 노드 찾기
     * @param index
     * @return
     */
    Node node(int index){
        Node x = this.head;
        for(int i=0; i< index; i++){
            x= x.next;
        }
        return x;
    }

    /**
     * 중간에 노드 추가
     * @param k
     * @param input
     */
    public void add(int k, Object input){

        // 만약 k가 0이라면 첫 번째 노드에 추가하는 것이기 때문에 addFirst를 사용한다.
        if(k==0){
            addFirst(input);
        }else{
            // k -1 번째 노드
            Node temp1 = node(k-1);
            // k 번째 노드
            Node temp2 = temp1.next;
            // 새로운 노드 생성
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정
            newNode.next = temp2;
            size++;
            //새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정함
            if(newNode.next == null){
                tail = newNode;
            }


        }
    }

    /**
     * 데이터 출력
     * @return
     */
    public String toString(){
        //노드가 없다면 []를 리턴
        if(size==0){
            return "[]";
        }
        Node temp = head;
        String str = "[";
        //다음 노드가 없을 때까지 반복문 실행
        while(temp.next!=null){
            str += temp.data + ",";
            temp = temp.next;
        }
        //마지막 노드를 출력결과에 포함시킴
        str += temp.data;
        return str+"]";
    }

    /**
     * 첫 번째 노드 삭제
     * @return
     */
    public Object removeFirst(){
        // 첫 번째 노드를 temp로 지정하고 head의 값을 두 번째 노드로 변경
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 저장
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    /**
     * 중간의 데이터 삭제
     * @param k
     * @return
     */
    public Object remove(int k){
        if(k==0)
            return removeFirst();
        // k-1번째 노드를 temp의 값으로 지정
        Node temp = node(k-1);
        // 삭제 노드를 todoDeleted에 기록
        // 삭제 노드를  지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없음
        Node todoDeleted = temp.next;
        // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정
        temp.next = temp.next.next;
        // 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장
        Object returnData = todoDeleted.data;
        if(todoDeleted==tail){
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;
    }

    /**
     * 엘리먼트의 크기 구하기
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 엘리먼트 값 가져오기
     * @param k
     * @return
     */
    public  Object get(int k){
        Node temp = node(k);
        return temp.data;
    }

    /**
     * 특정 값을 가진 엘리먼트의 인덱스 값 구하기
     * @param data
     * @return
     */
    public int indexOf(Object data){
        // 탐색 대상이 되는 노드를 temp로 지정한다.
        Node temp = head;
        int index = 0;
        // 탐색 값과 탐색 대상의 값 비교
        while(temp.data != data){
            temp = temp.next;
            index++;
            //더 이상 탐색 대상이 없으면 -1 리턴
            if(temp == null)
                return -1;
        }
        // 탐색 대상의 인덱스 값 리턴 
        return index;
    }

    /**
     * 반복자 생성
     * @return
     */
    public ListIterator listIterator(){
        return new ListIterator();
    }

    public class ListIterator{
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        ListIterator(){
            next = head;
            nextIndex = 0;
        }
        // 본 메소드를 호출하려면 cursor의 참조값이 기존 cursor.next로 변경됨
        public Object next(){
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext(){
            return nextIndex < size();
        }

        public void add(Object input){
            Node newNode = new Node(input);
            if(lastReturned == null){
                head= newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            tail = newNode;
            nextIndex++;
            size++;
        }

        public void remove(){
            if(nextIndex == 0){
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex-1);
            nextIndex--;
        }

    }

}
