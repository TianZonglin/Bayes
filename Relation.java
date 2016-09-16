package bayes;

/**
 * �����Ƕ����ϵ����룬���ڶ����ϵ�Ļ������ݳ�Ա
 * ����Ҫ�ĳ�Ա����
 * @author tang
 * @Time 2014-06-07
 */

public class Relation {//��ϵ��

	private int node_num1;//����Դ�ڵ���
	private int node_num2;//����Ŀ��ڵ�
    private int start;//��ʾԴ�±ꡣ
    private int end;  //��ʾĿ���±ꡣ
    
    /**
     * �÷����ǹ��캯���Թ�ϵ������г�ʼ��
     * @param n �ڵ��
     * @param m �ڵ��
     * @param rand_num1 ������
     * @param rand_num2 ������
     * @author tang
     * @Time 2014-06-07
     */
    
    public Relation(int n,int m,int rand_num1,int rand_num2){//���캯��ʵ�ֹ�ϵ�Ĵ���
    	int subscript1,subscript2;
        subscript1=n*10+rand_num1;
        subscript2=m*10+rand_num2;
        this.start=subscript1;
        this.end=subscript2;
        this.node_num1=n;
        this.node_num2=m;
    }
    
    /**
     * �÷������Ǵ�ӡ��ϵ��
     * @author tang
     * @Time 2014-06-07
     */
    
    public void print_rel(){//��ӡ��ϵ��
    	
    	System.out.print("<"+start+","+end+">"+" ");
    }
    
    /**
     * �÷������ǻ�ȡ��ʼ�������±꺯��
     * @return ��ʼ�±�
     * @author tang
     * @Time 2014-06-07
     */
    
    public int get_start(){//��ȡԴ�����±�
    	return start;
    }
    
    /**
     * �÷������ǻ�ȡ�����±�ĺ���
     * @author tang
     * @Time 2014-06-07
     */
    
    public int get_end(){//��ȡĿ�������±�
    	return end;
    }
    
    /**
     * �÷������ǻ�ȡ��ʼ�ڵ�ı��
     * @return �ڵ���
     * @author tang
     * @Time 2014-06-07
     */
    
    public int get_node_num1(){//��ȡԴ�ڵ���
    	return node_num1;
    }
    
    /**
     * �÷������ǻ�ȡ�����ڵ�ı��
     * @return �ڵ���
     * @author tang
     * @Time 2014-06-07
     */
    
    public int get_node_num2(){//��ȡĿ��ڵ���
    	return node_num2;
    }

}
