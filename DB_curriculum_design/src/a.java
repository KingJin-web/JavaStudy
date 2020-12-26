

import java.util.ArrayList;

public class a {
    ArrayList<String> list = new ArrayList<String>();
	public void add(){
	    list.add("????");
    }
}
class B {
    public static void main(String[] args) {
       a a = new a();
        a.list.add("你所要加的元素");
        System.out.println(a.list);
    }
}

