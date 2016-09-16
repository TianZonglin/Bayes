package bayes;

import java.util.ArrayList;
 /**
  * ������Ҫ���ܾ��Ƕ���ڵ�Ļ������ݽṹ��
  * ��Ҫ�ĳ�Ա����
  * @author tang
  * @Time 2014-06-08
  */

public class Node {

	private int node_num;//�ڵ��š�
	private int feature_count;//�ڵ���������������
	private Feature fea;      //������
	private ArrayList<Feature> feature_list=new ArrayList<Feature>();
	
	/**
	 * �÷����ǹ��캯������Ҫ��ʵ�ֶԽڵ�ĳ�ʼ��
	 * @param count ��������
	 * @param num �ڵ���
	 * @author tang
	 * @Time 2014-06-08
	 */
	
	public Node(int count,int num){//���캯��:����count������������num�ǽڵ�š�
		this.feature_count=count;
		this.node_num=num;
		for(int i=0;i<count;++i){
			fea=new Feature(i);//����һ���µ��������ݡ�
			feature_list.add(fea);//���������ݼ��뵽���������С�
		}
	}
	
	/**
	 * �÷������Ǵ�ӡ�����ĺ���
	 * @author tang
	 * @Time 2014-06-08
	 */
	
	public void print_feature(){//��ӡ�����ĺ�����
		for(int i=0;i<feature_list.size();++i){
			System.out.print(feature_list.get(i).get_data()+" ");
		}
	}
	
	/**
	 * �÷������ǻ�ȡ���������ĺ���
	 * @return ��������
	 * @author tang
	 * @Time 2014-06-08
	 */
	
	public int get_feature_count(){//��ȡ����������
		return feature_count;
	}
	
	/**
	 * �÷����ǻ�ȡ�ڵ�ŵĺ���
	 * @return �ڵ��
	 * @author tang
	 * @Time 2014-06-08
	 */
    public int get_node_num(){//��ȡ�ڵ��ŵĺ�����
    	return node_num;
    }
}
