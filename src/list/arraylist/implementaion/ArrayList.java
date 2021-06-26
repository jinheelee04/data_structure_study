package list.arraylist.implementaion;

public class ArrayList {
    private int size = 0; // 리스트에 들어있는 데이터 개수  
    private Object[] elementData = new Object[100]; // 고정된 크기를 가짐

    /**
     * 마지막 위치에 데이터 추가
     * @param element 저장하고자 하는 데이터 값
     * @return
     */
    public boolean addLast(Object element) {
        elementData[size++] = element;
        return true;
    }

    /**
     * 첫 번째 위치에 데이터 추가
     * @param element 저장하고자 하는 데이터 값
     * @return
     */
    public boolean addFirst(Object element) {
        return add(0, element);
    }

    /**
     * 지정한 위치에 데이터 추가
     * @param index 저장하고자 하는 위치
     * @param element 저장하고자 하는 데이터 값
     * @return
     */
    public boolean add(int index, Object element){
        for(int i =size-1;i>=index;i--){
            elementData[i+1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    /**
     * 지정한 위치의 데이터 값 반환
     * @param index 인덱스
     * @return
     */
    public Object get(int index){
        return elementData[index];
    }

    /**
     * 저장된 요소들을 문자열로 반환
     * @return
     */
    public String toString(){
        String str="[";
        for(int i=0;i<size;i++){
            str+= elementData[i] + (i==size-1? "" :", ");
        }
        return str+"]";
    }

    /**
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        Object removed = elementData[index];
        for(int i = index + 1; i <= size-1; i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    /**
     * 첫 번째 요소 삭제
     * @return 삭제한 요소의 값
     */
    public Object removeFirst(){
        return remove(0);
    }

    /**
     * 마지막 요소 삭제
     * @return 삭제한 요소의 값
     */
    public Object removeLast(){
        return remove(size-1);
    }

    /**
     * 리스트의 크기 구하기
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 입력 받은 값의 인덱스
     * @param value
     * @return
     */
    public int indexOf(Object value) {
        for(int i=0; i< elementData.length;i++){
            if(elementData[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
}
