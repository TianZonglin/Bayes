package bayes;

/**
 * ���������������࣬��Ҫ�Ƕ����������һЩ�������ݳ�Ա�ͺ�����Ա
 * �����У���ȡ���ݵĺ���
 * @author tang
 * @Time 2014-05-31
 */

public class Feature {//������ʵ������������ݵ��࣬�����Ժ�ļ��㡣

	private int data;//ʵ���õ����ݡ�
	
	/**
	 * �÷����ǹ��캯������Ҫ���Ƕ�����������
	 * @param n һ������
	 * @author tang
	 * @Time 2014-05-31
	 */
	
	public Feature(int n){
		this.data=n;
	}
	
	/**
	 * �÷����ǻ�ȡ���ݵĺ���
	 * @return ��������ľ�����ֵ
	 * @author tang
	 * @Time 2014-05-31
	 */
	public int get_data(){
		return data;
	}
}
