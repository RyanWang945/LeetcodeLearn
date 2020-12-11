package javalearn.CollectionDemo;

/**
 * @author Ryan
 * @date 2020/3/24 9:15
 */
public class Demo {
    public static void main(String[] args) {
//        Collection<String> lists=new ArrayList<>();
//        lists.add("aaa");
//        lists.add("bbb");
//        lists.add("ccc");
//        lists.add("ddd");
//        Iterator<String> it=lists.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        StringBuilder sb=new StringBuilder();
        sb.append("ab");
        sb.delete(1,2);
        System.out.println(sb.toString());
    }
}
