package bayes;
/**
 * ��Ҫ���Ƕ�����Wsnode��Ļ������ܺ�һЩ��������
 * @author tang
 * @Time 2014-06-20
 */
public class Wsnode{
  private Node node;
  private double match;
  
  /**
   * ���캯������Ҫ����ʵ�ֶ�wsnode�ĳ�ʼ��
   * @param ne �ڵ�
   * @param d ƥ���
   */
  public Wsnode(Node ne,double d){
	  this.node=ne;
	  this.match=d;
  }
}
