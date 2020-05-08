package DataStructure;

public class DoubleLinckedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试
		System.out.println("双向链表的测试");
		//先创建节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		//创建一个双向链表
		DoubleLinckedList doubleLickedList = new DoubleLinckedList();
		doubleLickedList.add(hero1);
		doubleLickedList.add(hero2);
		doubleLickedList.add(hero3);
		doubleLickedList.add(hero4);
		
		doubleLickedList.list();
		
		
		//修改
		HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
		doubleLickedList.update(newHeroNode);
		System.out.println("修改过后的双向链表情况：");
		doubleLickedList.list();
		
		//删除节点
		doubleLickedList.del(3);
		System.out.println("删除节点以后的情况");
		doubleLickedList.list();

	}

}


//创建一个双向链表的类
class DoubleLinckedList {
	//先初始化一个头节点，头节点不要动
	private HeroNode2 head = new HeroNode2(0, "", ""); //用来存放头节点，不存放具体的数据
	
	
	
	//添加一个节点到双向链表的最后
	public void add(HeroNode2 heroNode) {

		// 因为head节点不能动, 因此我们需要一个辅助指针(辅助遍历)
		HeroNode2 temp = head;
		// 遍历链表, 找到最后
		while (true) {
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后,将temp后移
			temp = temp.next;
		}
		// 当退出while循环时,temp就指向了链表的最后
		// 将最后这个节点的next 指向 新的节点
		// 构成双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	
	
	//修改一个节点的内容，可以看到双向链表的修改和单向链表的修改一样，只是类型改为了HeroNode2
	//修改节点的信息, 根据no编号来修改，即no编号不能改.
	// 说明
	// 1. 根据 newHeroNode 的 no 来修改即可
	public void update(HeroNode2 newHeroNode) {
		// 判断是否空
		if (head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		// 找到需要修改的节点, 根据no编号
		// 定义一个辅助变量
		HeroNode2 temp = head.next;
		boolean flag = false; // 表示是否找到该节点
		while (true) {
			if (temp == null) {
				break; // 已经遍历完链表
			}
			if (temp.no == newHeroNode.no) {
				// 找到
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag 判断是否找到要修改的节点
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else { // 没有找到
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
		}
	}
	
	
	
	// 删除节点(从双向链表中删除一个节点)
	//说明
	//1 对于双向链表, 我们可以直接找到要删除的这个节点
	//2 找到以后, 自我删除即可
	public void del(int no) {
		
		//判断当前是否为空链表, 空链表无法删除
		if (head.next == null) {
			System.out.println("当前链表为空, 无法删除");
			return;
		}
		HeroNode2 temp = head.next;  //辅助变量(辅助指针)
		boolean flag = false; // 标志是否找到待删除节点的
		while (true) {
			if (temp == null) { // 已经到链表的最后
				break;
			}
			if (temp.no == no) {
				// 找到的待删除节点的前一个节点temp
				flag = true;
				break;
			}
			temp = temp.next; // temp后移，遍历
		}
		// 判断flag
		if (flag) { // 找到
			// 可以删除
			//temp.next = temp.next.next;   [单向链表的删除方式, 在双向链表里不再适用]
			temp.pre.next = temp.next;
			//这里我们的代码有问题!
			//想一想假如要删除的节点是最后一个节点呢？
			//所以如果是最后一个节点就不需要执行下面这句话, 否则会出现空指针异常
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		} else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}
	
	
	//显示链表[遍历]
			public void list() {
				//判断链表是否为空
				if(head.next == null) {
				System.out.println("链表为空");
				return;
			}
				//因为头节点，不能动，因此我们需要一个辅助变量来遍历
				HeroNode2 temp = head.next;
				while(true) {
				//判断是否到链表最后
					if(temp == null) {
					  break;
				}
				//输出节点的信息
					System.out.println(temp);
				//将temp后移， 一定小心
					temp = temp.next;
			  }
		   }
	
	
	
	
}

//定义HeroNode, 每个HeroNode就是一个节点
class HeroNode2{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;//指向下一个节点, 默认为null
	public HeroNode2 pre; //指向前一个节点, 默认为null
	//构造器
	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
		
	}
	//为了显示方便，我们重写toString方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}

}
