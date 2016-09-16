package bayes;

import java.util.ArrayList;

/**
 * ���ඨ����Ǹ��ȫ�����ݣ���������ڵ�ͳ��ڵ㣬
 * ��Ҫ�ķ����ǽ�������������������D-���뺯��
 * @author tang
 * @Time   2014-05-29
 */

public class Cut_set {
	/*�������ڵ�*/
	private ArrayList<Node> inNode1=new ArrayList<Node>();
	private ArrayList<Node> inNode2=new ArrayList<Node>();
	private ArrayList<Node> outNode1=new ArrayList<Node>();
	private ArrayList<Node> outNode2=new ArrayList<Node>();
	
    /**
     * �÷����ǽ�����������Ҫ��ʵ�ֵ�������ArrayList�󽻼�
     * @param n_list1 ����1
     * @param n_list2 ����2
     * @return �������ϵĽ���
     * @author tang
     * @Time 2014-05-29
     */
	
	public ArrayList<Node> retainAll(ArrayList<Node> n_list1,ArrayList<Node> n_list2){
		int flag;
		/*�����һ��Ϊ���򷵻ؿռ�*/
		if(n_list1==null || n_list2==null)
			return null;
		else{
		/*ͨ������forѭ���ж�������������ͬ��Ԫ�ز��ϲ���һ��*/
		   for(int i=n_list1.size()-1;i>=0;i--){
			  flag=0;
			  for(int j=0;j<n_list2.size();++j){
				  if(n_list1.get(i).get_node_num()==n_list2.get(j).get_node_num())
					  flag=1;
			  }
			  if(flag==0){
				  n_list1.remove(i);
			  }
		  }
		  return n_list1;//���ؽ�����
		}
	}
    
	/**
	 * �÷����ǲ���������ʵ�ֵ���Ҫ������������ArrayList������
	 * @param n_list1
	 * @param n_list2
	 * @return �������ϵĲ���
	 * @author tang
	 * @Time 2014-05-29
	 */
	
	public ArrayList<Node> addAll(ArrayList<Node> n_list1,ArrayList<Node> n_list2){
		int flag;
		if(n_list1==null && n_list2!=null)
			return n_list2;
		else if(n_list1!=null && n_list2==null)
			return n_list1;
		else if(n_list1==null && n_list2==null)
			return null;
		else {
			for(int i=0;i<n_list1.size();++i){
				flag=1;
				for(int j=0;j<n_list2.size();++j){
					if(n_list1.get(i).get_node_num()==n_list2.get(j).get_node_num())
						flag=0;
				}
				if(flag==1)
					n_list2.add(n_list1.get(i));
			}
			return n_list2;
		}
		
	}
	
	/**
	 * �÷�������D-����ķ�������Ҫ��ʵ�ֵĹ��ܾ���
	 * ����ͼ�͸����ڵ�����佻��
	 * @param graph
	 * @param node_lst
	 * @param n1
	 * @param n2
	 * @return �����(�ڵ�����)
	 * @author tang
	 * @Time 2014-05-29
	 */
	
    public ArrayList<Node> D_separate(Graph graph,ArrayList<Node> node_lst,Node n1,Node n2){
    	ArrayList<Node> cutset=new ArrayList<Node>();//��ʼ���ڵ�
    	for(int i=0;i<graph.get_vertex_count();++i){
    		for(int j=0;j<graph.get_vertex_count();++j){
    			if(graph.get_matrix_value(i,j)==1){
    				//System.out.print("<"+i+","+j+">"+" ");
    				if(i==n1.get_node_num()){
        				for(int k=0;k<node_lst.size();++k){
        					if(j==node_lst.get(k).get_node_num())
        						outNode1.add(node_lst.get(k));
        				}
    				}
    				if(j==n1.get_node_num()){
        				for(int k=0;k<node_lst.size();++k){
        					if(i==node_lst.get(k).get_node_num())
        						inNode1.add(node_lst.get(k));
        				}
    				}
    				if(i==n2.get_node_num()){
        				for(int k=0;k<node_lst.size();++k){
        					if(j==node_lst.get(k).get_node_num())
        						outNode2.add(node_lst.get(k));
        				}
    				}
    				if(j==n2.get_node_num()){
        				for(int k=0;k<node_lst.size();++k){
        					if(i==node_lst.get(k).get_node_num())
        						inNode2.add(node_lst.get(k));
        				}
    				}
    			}
    		}
    	}
        
    	/*
    	System.out.print("outNode1=");
    	for(int i=0;i<outNode1.size();++i){
    		System.out.print(outNode1.get(i).get_node_num()+" ");
    	}
    	System.out.print("inNode1=");
    	for(int i=0;i<inNode1.size();++i)
    		System.out.print(inNode1.get(i).get_node_num()+" ");
    	System.out.print("outNode2=");
    	for(int i=0;i<outNode2.size();++i)
    		System.out.print(outNode2.get(i).get_node_num()+" ");
    	System.out.print("inNode2=");
    	for(int i=0;i<inNode2.size();++i)
    		System.out.print(inNode2.get(i).get_node_num()+" ");
    	*/
    	
    	/*���нڵ㽻�����㷨*/
    	cutset=addAll(cutset,retainAll(outNode1,inNode2));
    	cutset=addAll(cutset,retainAll(outNode2,inNode1));
    	cutset=addAll(cutset,retainAll(inNode1,inNode2));
    	if(!retainAll(outNode1,outNode2).isEmpty()){
    		cutset=addAll(cutset,retainAll(outNode1,outNode2));
    	}
    	//System.out.print("������:"+cutset.get(0).get_node_num());
		return cutset;
    }
}
