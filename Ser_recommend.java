package bayes;

import java.util.ArrayList;

/*�����Ƽ��㷨*/
public class Ser_recommend {
  private ArrayList<Node> rnodes=new ArrayList<Node>();
  private ArrayList<Wsnode> wsnodes=new ArrayList<Wsnode>();
  public void similar_match(int RE,Node n){
	  System.out.print("����������ƶ�ƥ��");
  }
  
  public void ser_recommend(Graph graph,ArrayList<Node> node_lst,Relation_table rel_table){
	 int re=0;
	 Wsnode ws;
	 for(int j=0;j<node_lst.size();++j){
		 rnodes.add(node_lst.get(j));
		 ws=new Wsnode(node_lst.get(j),1.0);
		 wsnodes.add(ws);
	 }
	 //System.out.print("rnodes�����еĽڵ�\n");
	 for(int i=0;i<rnodes.size();++i){
		 System.out.print("�ڵ�"+rnodes.get(i).get_node_num()+" ");
		 graph.get_node_path(rnodes.get(i));//����ĳ���ڵ㣬��Ϊ����
		 System.out.println();
	 }
  }
}
