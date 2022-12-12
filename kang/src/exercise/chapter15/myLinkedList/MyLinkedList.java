package exercise.chapter15.myLinkedList;

public class MyLinkedList {
	private MyListNode head;
	int cnt;
	
	public MyLinkedList() {
		head = null;
		cnt = 0;
	}
	
	public MyListNode addElement(String data) {
		MyListNode newNode;
		if(head == null) {
			newNode = new MyListNode(data);
			head = newNode;
		}
		else {
			newNode = new MyListNode(data);
			MyListNode temp = head;
			while(temp.next != null) temp = temp.next;
			temp.next = newNode;
		}
		cnt++;
		return newNode;
	}
	
	public MyListNode insertElement(int position, String data) {
		int i;
		MyListNode tempNode = head;
		MyListNode newNode = new MyListNode(data);
		
		if(position<0 || position >cnt) {
			System.out.println("추가할 위치 오류입니다. 현재 리스트의 개수는 "+cnt+"개 입니다.")	;
			return null;
		}
		
		if(position==0) {
			newNode.next = head;
			head = newNode;
		} else {
			MyListNode preNode = null;
			for(i=0;i<position;i++) {
				preNode = tempNode;
				tempNode = tempNode.next;
			}
			newNode.next=preNode.next;
			preNode.next = newNode;
		}
		cnt++;
		return newNode;
	}
	
	public MyListNode removeElement(int position) {
		int i;
		MyListNode tempNode = head;
		
		if(position>=cnt) {
			System.out.println("삭제할 위치 오류입니다. 현재 리스트의 갯수는 "+cnt+"개 입니다.");
			return null;
		}
		
		if(position == 0) head = tempNode.next;
		else {
			MyListNode preNode = null;
			for(i=0;i<position;i++) {
				preNode = tempNode;
				tempNode = tempNode.next;
			}
			preNode.next = tempNode.next;
		}
		cnt--;
		System.out.println(position+"번째 항목이 삭제되었습니다.");
		
		return tempNode;
	}
	
	public MyListNode getNode(int position) {
		int i;
		MyListNode tempNode = head;
		
		if(position >= cnt) {
			System.out.println("검색 위치 오류입니다. 현재 리스트의 개수는 "+cnt+"개 입니다.");
			return null;
		}
		if(position == 0) {
			return head;
		}
		for(i=0; i<position; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	public String getElement(int position) {
		int i;
		MyListNode tempNode = head;
		
		if(position >= cnt) {
			System.out.println("검색 위치 오류입니다. 현재 리스트의 개수는 "+cnt+"개 입니다.");
			return new String("error");
		}
		if(position == 0) {
			return head.getData();
		}
		for(i=0; i<position; i++) {
			tempNode = tempNode.next;
		}
		return tempNode.getData();
	}
	
	public int getSize() {
		return cnt;
	}
	
	public void printAll() {
		if(cnt==0) {
			System.out.println("출력할 내용이 없습니다.");
			return;
		}
		
		MyListNode temp = head;
		while(temp != null) {
			System.out.print(temp.getData());
			temp = temp.next;
			if(temp != null) System.out.print("->");
		}
		System.out.println("");
	}
	
	public boolean isEmpty() {
		if(head==null) return true;
		else return false;
	}
	
	public void removeAll() {
		head = null;
		cnt = 0;
	}
}
