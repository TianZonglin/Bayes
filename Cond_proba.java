package bayes;

/**
 * ����ʵ�ֵ��������ֲ���Ķ���,�����������洢
 * �Ǻͷ���������µ���������,ͬʱ���л�ȡ��Щ
 * �������ʵĺ���
 * @author tang
 * @Time   2014-05-28
 **/

public class Cond_proba{
	private float node_cp;
	private float non_node_cp;
	
	/**
	 * �����ǹ��췽�������ڴ洢�����������ʡ�
	 * @param cp1 ��������1
	 * @param cp2 ��������2
	 * @author tang
	 * @Time  2014-05-28
	 */
	
	public Cond_proba(float cp1,float cp2){
		this.node_cp=cp1;
		this.non_node_cp=cp2;
	}
	
	/**
	 * �÷����ǻ�ȡ�������µ���������
	 * @return �������µ���������
	 * @author tang
	 * @Time   2014-05-28
	 */
    public float get_cp(){ 
    	return node_cp;
    }
    
    /**
     * �÷����ǻ�ȡ�������µ���������
     * @return �������µ���������
     * @author tang
     * @Time 2014-05-28
     */
    
    public float get_non_cp(){
    	return non_node_cp;
    }
}
