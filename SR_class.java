package bayes;

import java.util.ArrayList;
import java.util.Collections;

  /**
   * ������Ƕ���S_class��R_class����Ļ����ṹ
   * ����Ҫ�ķ���
   * @author tang
   * @Time 2014-06-05
   */

public class SR_class {
	private ArrayList<Node_pair> node_pair_lst;
	private Node_pair node_pair;
	
	/**
	 * �÷����ǹ��캯��������ֻ��һ�����ǳ�ʼ���ڵ������
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public SR_class(){
		node_pair_lst=new ArrayList<Node_pair>();
	}
	
	/**
	 * �÷�������ڵ����������ӽڵ�
	 * @param node1 �ڵ�1
	 * @param node2 �ڵ�2
	 * @param node_mutual �ڵ㻥��Ϣ
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public void add_node_pair(Node node1,Node node2,float node_mutual){
		node_pair=new Node_pair(node1,node2,node_mutual);
		node_pair_lst.add(node_pair);
	}
	
	/**
	 * �÷�������ڵ����������ӽڵ�
	 * @param node1 �ڵ�1
	 * @param node2 �ڵ�2
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public void add_node_pair(Node_pair node_p){
		//node_pair=new Node_pair(node1,node2);
		node_pair_lst.add(node_p);
	}
	
	/**
	 * �÷������Ǵ�ӡS_class��Ķ���ĺ���
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public void print_info(){
		int num1,num2;
		for(int i=0;i<node_pair_lst.size();++i){
			if(i!=0 && i%2==0)
				System.out.println();
			num1=node_pair_lst.get(i).get_node1().get_node_num();
			num2=node_pair_lst.get(i).get_node2().get_node_num();
			System.out.print("<"+num1+","+num2+">"+node_pair_lst.get(i).get_mutual()+" ");
		}
	}
	
	/**
	 * �÷������Ǵ�ӡR_class��Ķ���ĺ���
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public void print_R_info(){
		int num1,num2;
		for(int i=0;i<node_pair_lst.size();++i){
			if(i!=0 && i%2==0)
				System.out.println();
			num1=node_pair_lst.get(i).get_node1().get_node_num();
			num2=node_pair_lst.get(i).get_node2().get_node_num();
			System.out.print("<"+num1+","+num2+">"+" ");
		}
	}

     /**
      * �÷���ʵ�ֵĹ��ܾ��Ƕ�S_class��R_class��������
      * @author tang
	  * @Time 2014-06-07
      */
	
	public void sort_lst(){
		Node_comparator node_cmp=new Node_comparator();
		Collections.sort(node_pair_lst,node_cmp);
	}
	
	/**
	 * �÷������ǻ�ȡ�ڵ������
	 * @return �ڵ������
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public ArrayList<Node_pair> get_nodepair_list(){
		return node_pair_lst;
	}
}
