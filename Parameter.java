package bayes;

import java.util.ArrayList;

/**
 * ������Ҫ�ǲ���ѧϰ��ʵ���㷨��
 * @author tang
 * @Time 2014-06-08
 */

public class Parameter {
    private ArrayList<Cond_proba> cond_proba_lst=new ArrayList<Cond_proba>();
    
	public float test(Node n1,ArrayList<Node> parent_node,Relation_table rel_table, int[] fea_sum1){
		int sub1,sub2;
		float val=0;
		float val1=0;
		float val2=0;
		if(1==parent_node.size()){
			for(int i=0;i<parent_node.get(0).get_feature_count();++i){
				sub1=parent_node.get(0).get_node_num()*10+i;//���һ���������±ꡣ
				
				for(int j=0;j<n1.get_feature_count();++j){
					sub2=n1.get_node_num()*10+j;//�ڶ����������±ꡣ
					val+=p_probability(sub1,sub2,parent_node.get(0),n1,rel_table,fea_sum1);
				}
			}
			
			return val;
		}
		else{
			
			for(int i=0;i<parent_node.get(0).get_feature_count();++i){
				
				sub1=parent_node.get(0).get_node_num()*10+i;//���һ���������±ꡣ
				for(int j=0;j<n1.get_feature_count();++j){
					sub2=n1.get_node_num()*10+j;//�ڶ����������±ꡣ
					
					val1+=p_probability(sub1,sub2,parent_node.get(0),n1,rel_table,fea_sum1);
				}
			}
			
			for(int i=0;i<parent_node.get(1).get_feature_count();++i){
				
				sub1=parent_node.get(0).get_node_num()*10+i;//���һ���������±ꡣ
				for(int j=0;j<n1.get_feature_count();++j){
					sub2=n1.get_node_num()*10+j;//�ڶ����������±ꡣ
					
					val2+=p_probability(sub1,sub2,parent_node.get(0),n1,rel_table,fea_sum1);
				}
			}
			val2=val1*val2;
			return val2;
		}

	}
	
	/**
	 * �÷����ǲ���ѧϰ��ʹ�õ����������ʵĻ����㷨
	 * ���ĵ�˼����ǹ�ϵ���ֵĴ������������������ֵ��ܴ���
	 * @param sub1 �����±�
	 * @param sub2 �����±�
	 * @param n1   �ڵ��
	 * @param n2   �ڵ��
	 * @param rel_tab ��ϵ��
	 * @param fea_sum1�洢�������ִ���������
	 * @return ������������
	 * @author tang
	 * @Time 2014-06-08
	 */
	
	public float p_probability(int sub1,int sub2,Node n1,Node n2,Relation_table rel_tab,int[] fea_sum1){
		float pp=0;
		int frequency1,frequency2;
		frequency1=0;
		frequency2=0;
		frequency1=fea_sum1[sub1];//�±�1������������ڹ�ϵ���г��ֵ��ܴ�����
		
		/*ͨ��forѭ���ж��±������������ֵ*/
		for(int i=0;i<rel_tab.get_relation_list().size();++i){
			
			if(n1.get_node_num()==rel_tab.get_relation_list().get(i).get_node_num1() &&
			   n2.get_node_num()==rel_tab.get_relation_list().get(i).get_node_num2()){
				
				if(sub1==rel_tab.get_relation_list().get(i).get_start() && sub2==rel_tab.get_relation_list().get(i).get_end())
					frequency2++;
			}
		}

        if(frequency1!=0 && frequency2!=0){
    		pp=(float)frequency2/frequency1;
    		return pp;
        }else 
        	return 0;

	}

	
	public void non_cond_probability(){
		//�����Ǽ���ǽڵ���������ʵĺ�����
	}
	
	/**
	 * �÷�������Ҫ�Ĳ���ѧϰ�ĺ�����ʵ���˲���ѧϰ����Ҫ����
	 * @param graph ͼ
	 * @param total ��������
	 * @param a     ����
	 * @param node_lst �ڵ�����
	 * @param rel   ��ϵ��
	 * @param fea   ������������
	 * @author tang
	 * @Time  2014-06-08
	 */
	
    public void parameter(Graph graph,int total,int[] a,ArrayList<Node> node_lst,Relation_table rel,int[] fea){
    	Cond_proba cond_proba;
    	ArrayList<Node> parent_node=new ArrayList<Node>();//���常�ڵ�
    	float node_probability=0;
    	float cp=0;
    	System.out.println("�ڵ����������ǣ�");
    	
    	for(int i=0;i<node_lst.size();++i){
    		if(graph.inDegree(node_lst.get(i))==0){
    			node_probability=(float)a[node_lst.get(i).get_node_num()]/total;
    			System.out.println("�ڵ�"+node_lst.get(i).get_node_num()+"����="+node_probability+" ");//�õ��ڵ��������ʡ�
    		}
    	}
    	
    	System.out.println("\n�ڵ�͸��ڵ������������:");
    	//�������������ʷֲ���
    	for(int n=0;n<node_lst.size();++n){
    		
    		//��ȡĳ���ڵ�ĸ��ڵ㡣
    		for(int i=0;i<graph.get_vertex_count();++i)
    			for(int j=0;j<graph.get_vertex_count();++j){
    				if(graph.get_matrix_value(i, j)==1){
    					if(j==node_lst.get(n).get_node_num()){
    						parent_node.add(node_lst.get(i));//�õ����ڵ�����
    					}
    				}
    			}
    		
    		if(!parent_node.isEmpty()){
    			System.out.print("�ڵ�"+n+"�ĸ��ڵ��ǣ�");
        		for(int k=0;k<parent_node.size();++k)
        			System.out.print(parent_node.get(k).get_node_num()+" ");
        		cp=test(node_lst.get(n),parent_node,rel,fea);
        		if(cp>1 && cp<2)
        			cp=cp;
        		if(cp>2)
        			cp=cp;
        		System.out.println();
        		System.out.print("��������="+cp+" ");//**************************����������ʾ
        		System.out.print("\n");
        		cond_proba=new Cond_proba(cp,1-cp);
        		cond_proba_lst.add(cond_proba);
    		}
    		parent_node.clear();
    	}
    }
}
