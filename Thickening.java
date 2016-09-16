package bayes;

import java.util.ArrayList;

/**
 * �������Thickening�㷨����Ҫʵ���ļ�
 * �������л���Ϣ���㺯���������������㺯��
 * @author tang
 * @Time 2014-06-07
 */

public class Thickening {
	private Cut_set cs;
	
	/**
	 * �÷����ǹ��캯��������ʵ���˸�ĳ�ʼ��
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public Thickening(){
		cs=new Cut_set();//��ʼ�������
	}
	
	/**
	 * �÷����Ǽ��㻥��Ϣ�ĺ�������Ҫ��ʵ�ֵľ��Ǽ���ڵ�֮��Ļ���Ϣ
	 * @param n1 �ڵ�1
	 * @param n2 �ڵ�2 
	 * @param cutset �
	 * @return �������Ļ���Ϣ
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public float mutual_node(Node n1,Node n2,ArrayList<Node> cutset){
		float val = 0;
		for(int i=0;i<n1.get_feature_count();++i){
			for(int j=0;j<n2.get_feature_count();++j){
				for(int k=0;k<cutset.get(0).get_feature_count();++k){
					val=0;
					val+=val;//���ﻥ��Ϣ�ļ������Ǻ�Ϊ0�ġ�@@@@@@@@@@@@@@@@@@@@@
				}
			}
		}
		return val;
	}
	
	public void joint_probability(int sub1,int sub2,Node n1,Node n2,Relation_table rel_tab){
		System.out.println("���Ǽ������ϸ��ʵĺ���");
	}
	
	/**
	 * �÷�������Thickening�㷨����Ҫ�ĺ�����
	 * ʵ���˻����Ĺ���
	 * @param graph1 ͼ
	 * @param node_lst ��������
	 * @param r S_class�����
	 * @return ������ĵ�ͼ
	 * @author tang
	 * @Time 2014-06-07
	 */
	
	public Graph thicken(Graph graph1,ArrayList<Node> node_lst,SR_class r){
		float threshold=0;

		ArrayList<Node> cs_list=new ArrayList<Node>();
		System.out.println("��������"+r.get_nodepair_list().size()+"\n�õ��ĸ�����:");
		//System.out.println("r.get_nodepair_list().get(i).get_node1().get_node_num()----->"+r.get_nodepair_list().get(0).get_node1().get_node_num());
		for(int i=0;i<r.get_nodepair_list().size();i++){
			int m,n;
			m=r.get_nodepair_list().get(i).get_node1().get_node_num();
			n=r.get_nodepair_list().get(i).get_node2().get_node_num();
			
			System.out.println("<"+r.get_nodepair_list().get(i).get_node1().get_node_num()+","+r.get_nodepair_list().get(i).get_node2().get_node_num()+">");

			cs_list=cs.D_separate(graph1,node_lst,r.get_nodepair_list().get(i).get_node1(),r.get_nodepair_list().get(i).get_node2());
		   
			System.out.println("result����>"+cs_list.size());
			
			if(cs_list.size()!=0){
				System.out.print("����<"+r.get_nodepair_list().get(i).get_node1().get_node_num()+","+
			    		r.get_nodepair_list().get(i).get_node2().get_node_num()+">"+"�ĸ�ǣ�"+cs_list.get(0).get_node_num()+" ");
			

			//for(int ii=0;ii<cs_list.size();ii++){System.out.print(cs_list.get(ii).get_node_num()+" ");}

				System.out.println();
				threshold=mutual_node(r.get_nodepair_list().get(i).get_node1(),r.get_nodepair_list().get(i).get_node2(),cs_list);
			    if(threshold>0.15f){//0.15f�Ǿ����������ĳ�����ֵ��С��
			        graph1.add_edge1(m, n);
			    }
			}
		}
		return graph1;
	}
	
}
