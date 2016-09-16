package bayes;

import java.util.ArrayList;

/**
 * ������Ҫ����ʵ��Thinning�㷨���࣬��һ������ͼ�ı�
 * @author tang
 * @Time 2014-06-06
 */

public class Thinning {
	private Cut_set cs;
	
	/**
	 * �÷����ǹ��캯���������Ǵ�����ʼ��
	 * @author tang
	 * @Time 2014-06-06
	 */
	
	public Thinning(){
		cs=new Cut_set();
	}
	
	/**
	 * �÷�����Thinning�����Ҫ�ĺ�������ʵ�־���ͼ�Ĺ���
	 * @param graph ͼ
	 * @param node_lst �ڵ�����
	 * @author tang
	 * @Time 2014-06-06
	 */
	
	public void thinning(Graph graph,ArrayList<Node> node_lst){
		float val=0;
		ArrayList<Node> cs_list=new ArrayList<Node>();
		Cut_set cs=new Cut_set();
		System.out.println("���ĸ�����:");
		Node n1 = null,n2 = null;
		for(int i=0;i<graph.get_vertex_count();++i){
			for(int j=0;j<graph.get_vertex_count();++j){
				if(graph.get_matrix_value(i, j)==1){
					graph.delete_edge(i, j);//��������ڵ�֮���б߾�ɾ�������ߡ�
					for(int k=0;k<node_lst.size();++k){
						if(i==node_lst.get(k).get_node_num())
							n1=node_lst.get(k);
						if(j==node_lst.get(k).get_node_num())
							n2=node_lst.get(k);
					}
					//System.out.print("<"+n1.get_node_num()+","+n2.get_node_num()+">"+" ");
					cs_list=cs.D_separate(graph, node_lst, n1, n2);
                    if(cs_list.isEmpty()){
                    	//System.out.print("�ռ�"+" ");
                    	val=0.2f;
                    	if(val>0.15f)
                    		System.out.print("�ɹ�"+" ");
                    }else{
                    	//�����С����ǿ����Ǿͼ����������ʡ�
                    	//����mutual_node�����Ϳ����ˡ�
                    }
				}
			}
		}
		graph.print_digraph();
	}
	
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @param cutset
	 * @return
	 */
	
	public float mutual_node(Node n1,Node n2,ArrayList<Node> cutset){
		float val = 0;
		float result=0;
		for(int p=0;p<cutset.size();++p){
		   for(int i=0;i<n1.get_feature_count();++i){
			  for(int j=0;j<n2.get_feature_count();++j){
				for(int k=0;k<cutset.get(p).get_feature_count();++k){
					val=0;
					val+=val;//���ﻥ��Ϣ�ļ������Ǻ�Ϊ0�ġ�
				 }
			  }
		}
        result+=val; 
	 }
     return result;
   }
}
