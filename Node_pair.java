package bayes;

 /**
  * ������Ҫ������ʵ�ִ�Žڵ�ԵĴ���
  * @author tang
  * @Time 2014-06-08
  */

public class Node_pair {
	private int node_num1;//�ڵ�1�ı��
	private int node_num2;//�ڵ�2�ı��
	private Node node1;
	private Node node2;
	private float node_mutual;//��Žڵ�Ե���ֵ��
    
    /**
     * �÷����ǹ��캯������Ҫʵ�ֵ��Ǵ�Žڵ��
     * @param n1 �ڵ�1
     * @param n2 �ڵ�2
     * @param mutual ����Ϣ
     * @author tang
     * @Time 2014-06-08
     */
	
    public Node_pair(Node n1,Node n2,float mutual){
    	this.node_num1=n1.get_node_num();
    	this.node_num2=n2.get_node_num();
    	
    	this.node1=n1;//ֱ�Ӹ�ֵ
    	this.node2=n2;//ֱ�Ӹ�ֵ
    	this.node_mutual=mutual;
    }
    
    /**
     * ���ع��캯�������ڴ�Žڵ��
     * @param n1 �ڵ�1
     * @param n2 �ڵ�2
     * @author tang
     * @Time 2014-06-08
     */
    
    public Node_pair(Node n1,Node n2){
    	this.node_num1=n1.get_node_num();
    	this.node_num2=n2.get_node_num();
    }
    
    /**
     * ��ȡһ���ڵ�
     * @return �ڵ��
     * @author tang
     * @Time 2014-06-08
     */
    
    public int get_node_num1(){
    	return node_num1;
    }
    
    /**
     * ��ȡһ���ڵ�
     * @return �ڵ��
     * @author tang
     * @Time 2014-06-08
     */
    
    public int get_node_num2(){
    	return node_num2;
    }
    
    /**
     * ��ȡ�ڵ�ԵĻ���Ϣ
     * @return ����Ϣ
     * @author tang
     * @Time 2014-06-08
     */
    
    public float get_mutual(){
    	return node_mutual;
    }
    
    /**
     * ��ȡ�ڵ�
     * @return �ڵ�
     * @author tang
     * @Time 2014-06-08
     */
    
    public Node get_node1(){
    	return node1;
    }
    
    /**
     * ��ȡ�ڵ�
     * @return �ڵ�
     * @author tang
     * @Time 2014-06-08
     */
    
    public Node get_node2(){
    	return node2;
    }
}
