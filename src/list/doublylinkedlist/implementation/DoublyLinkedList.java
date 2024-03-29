package list.doublylinkedlist.implementation;

public class DoublyLinkedList {
    // 첫 번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size =0;
    
    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;
        private Node prev;
        
        public Node(Object input){
            this.data = input;
            this.next = null;
            this.prev = null;
        }
        
        //출력
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input){
        // 노드 생성
        Node newNode = new Node(input);
        // 새로운 노드의 다음 노드로 헤드를 지정
        newNode.next = head;
        // 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정
         if(head != null)
            head.prev = newNode;
         // 헤드로 새로운 노드 지정
         head  = newNode;
         size++;
         if(head.next == null)
             tail = head;

    }

    public void addLast(Object input) {
        // 노드 생성
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 첫 번째 노드를 추가하는 메소드를 사용
        if(size ==0){
            addFirst(input);
        }else{
            // tail의 다음 노드로 생성한 노드를 지정
            tail.next = newNode;
            // 새로운 노드의 이전 노드로 tail을 지정
            newNode.prev = tail;
            // 마지막 노드를 갱신
            tail = newNode;
            // 엘리먼트의 개수를 1증가 시킴
            size++;
        }
    }

    Node node(int index){
        // 노드의 인덱스가 전체 노드 수의 반보다 작을 경우
        if(index < size / 2){
            // head부터 next를 이용해서 인덱스에 해당하는 노드 찾기
            Node x = this.head;
            for(int i=0;i<index;i++)
                x = x.next;
            return x;
        }else {
            // tail부터 prev를 이용해서 인덱스에 해당하는 노드 찾기
            Node x = this.tail;
            for(int i=size-1 ; i>index; i--)
                x = x.prev;
            return x;
        }
    }

    public void add(int k, Object input) {
        if(k==0){
            addFirst(input);
        }else{
            // k-1 번째 노드
            Node temp1 = node(k-1);
            // k 번째 노드
            Node temp2 = temp1.next;
            // 새로운 노드 생성
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정
            newNode.next = temp2;
            // temp2의 이전 노드로 새로운 노드 지정
            if(temp2 != null)
                temp2.prev = newNode;
            // 새로운 노드의 이전 노드로 temp1을 지정
            newNode.prev = temp1;
            size ++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
            if(newNode.next == null){
                tail = newNode;
            }

        }
    }

    public Object removeFirst(){
        // 첫 번째 노드를 temp로 지정하고 head의 값을 두 번째 노드로 변경
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 저장
        Object returnData = temp.data;
        temp = null;
        if(head !=null)
            head.prev = null;
        size--;
        return returnData;
    }
    public Object remove(int k) {
        if(k==0)
            return removeFirst();
        // k-1번째 노드를 temp로 지정
        Node temp = node(k-1);
        // temp.next를 삭제하기 전에 todoDeleted 변수에 저장
        Node todoDeleted = temp.next;
        // 삭제 대상 노드를 연결에서 분리
        temp.next = temp.next.next;
        if(temp.next !=null){
            // 삭제할 노드의 전후 노드를 연결
            temp.next.prev =temp;
        }
        // 삭제된 노드의 데이터를 리턴하기 위해서 returnData에 데이터 저장
        Object returnData = todoDeleted.data;
        // 삭제된 노드가 tail이었다면 tail을 이전 노드를 tail로 지정
        if(todoDeleted == tail){
            tail = temp;
        }
        // cur.next를 삭제
        todoDeleted = null;
        size--;
        return returnData;

    }
    public Object removeLast() {
       return remove(size-1);
    }

    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    public int indexOf(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정
        Node temp = head;
        // 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용
        int index = 0;
        // 탐색 값과 탐색 대상의 값을 비교
        while (temp.data != data) {
            temp = temp.next;
            index++;
            // temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것을 의미
            if (temp == null)
                return -1;
        }
        // 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴
        return index;
    }
}
