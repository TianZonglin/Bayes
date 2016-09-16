package bayes;
import java.util.Scanner; //����ɨ����
import java.util.ArrayList;

/**
 * ������Drafting������������������࣬�������кܶ�ķ�������Ҫ��
 * ����Ϣ������������ʺ������������ʺ���......
 * @author tang
 * @Time 2014-05-27
 */

public class Drawing {
	
	private static int sum_node[];//ÿ���ڵ���������������顣
	private static int fea_total;//��������
	private static int fea_sum[];//���������ϵ���������顣
	private int fea_sum_count=0;//�趨������������飬���ڼ���������ʺ��������ʡ�
	private static int node_count=0;//(int)(Math.random()*7);//�ڵ�����
	private static SR_class r_class=new SR_class();
	private static Relation_table rel_table;
	private static ArrayList<Node> node_list;
	private SR_class s_class=new SR_class();
	private float threshold=0.15f;//��ֵ���ڽ��бȽ�
	static int[] fea_count = new int[50];//{5,3,6,7,7,3,5,5,3,6,7,7,3,5};//��ͬ�ڵ���������������
	private static int[] fea_rel_count = new int[50];//int fea_rel_count[]={6,5,5,5,2,2,8,9,7,2};//�����ڵ�֮��Ĺ�ϵ������
    
	private static int rand1 = 0;

	/**
	 * �÷����ǹ��캯������Ҫ���ڳ�ʼ��һЩ�����ı���
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public Drawing(){
	
		System.out.print("node_count:"+node_count+"\n");
		fea_sum_count = 20*node_count;
		sum_node=new int[node_count];
		fea_total=0;
		node_list=new ArrayList<Node>();
		
		/*System.out.print("*******************���******************\n\nfea_count[]= ");
		for(int i=0;i<node_count;i++){ //////random-->fea_count[]=1~15
			fea_count[i] = 5+(int)(Math.random()*15);
			System.out.print(fea_count[i]+" ");
		}
		System.out.println();
		//rand1=10;//1+(int)(Math.random()*node_count);/////random-->fea_real_count[]=1~10
		System.out.println("fea_rel_count.length= "+rand1);
		
		System.out.print("fea_rel_count[]= ");
		for(int i=0;i<rand1;i++){/////random-->fea_rel_count[]=1~15
			fea_rel_count[i] = 1 + (int)(Math.random()*15);
			System.out.print(fea_rel_count[i]+" ");
		}
		System.out.println();*/
	}
	
	
	/**
	 * �÷����ǳ�ʼ���ڵ�ĺ�������Ҫ���ڽ��ڵ�����ȫ����ʼ��
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public void init_node(){
				
		Node node;
		for(int i=0;i<node_count;++i){
			
			node=new Node(fea_count[i],i);
			node_list.add(node);
			
		}
		
	}

	
	/**
	 * �÷����Ǵ�ӡ�ڵ�ĺ���
	 * ��Ҫ�Ǳ�����ӡ���еĽڵ��ʶ��
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public void print_node(){
		System.out.println("ϵͳ��ȫ���ڵ���:");
		for(int j=0;j<node_count;++j)
			System.out.print("�ڵ�"+j+" ");
		System.out.println("\n\n");
		System.out.println("��ͬ�ڵ��ڵ���������:");
		for(int i=0;i<node_count;++i){
			System.out.print("��"+i+"�Žڵ��ڵ�������:");
			node_list.get(i).print_feature();
			System.out.println();
		}
		System.out.print("\n\n");
	}
	
	
	/**
	 * �÷����ǳ�ʼ����ϵ��ĺ�������Ҫ���ܾ������ö���
	 * �õ�����������й�ϵ��ĳ�ʼ��
	 * @author tang
	 * @Time 2014-05-27
	 */
	public void init_rel_table(){
		int n[]=new int[rand1];//{0,0,0,1,2,2,2,3,4,6};
		int m[]=new int[rand1];//{1,2,4,2,3,4,5,4,6,5};

/*		for(int i=0;i<rand1;i++){
			n[i]=(int)(Math.random()*(node_count-1));
		    m[i]=(int)(Math.random()*(node_count-1));
		    System.out.print(n[i]+" ");
		}*/
		
		Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.print("������n[i],����"+rand1+"��:");
		for(int i=0;i<rand1;i++) n[i]=input.nextInt();
		System.out.print("������m[i],����"+rand1+"��:");
		for(int i=0;i<rand1;i++) m[i]=input.nextInt();
		
		System.out.println("-------------------------");
		System.out.print("n[]= ");
		for(int i=0;i<rand1;i++){System.out.print(n[i]+" ");}
		System.out.println();
		System.out.print("m[]= ");
		for(int i=0;i<rand1;i++){System.out.print(m[i]+" ");}
		rel_table=new Relation_table(n,m,rand1,fea_count,fea_rel_count,rand1);//////////////////////////////////////////////
	}
	
	
	/**
	 * �÷����Ǵ�ӡ��ϵ��ĺ��������Ǳ�����ϵ����ӡ
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public void print_rel_table(){
		rel_table.print_relation();
		System.out.print("\n\n\n");
	}

	
	/**
	 * �÷���������׼����������Ҫ�Ĺ��ܾ��ǳ�ʼ��һЩ��������
	 * ����fea_total��fea_sum��sum_node
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public void data_preparation(){
		fea_sum=new int[fea_sum_count];
		System.out.print("�����ڵ������������:");
		
		for(int i=0;i<node_count;i++){
			fea_total+=fea_count[i];
			sum_node[i]=fea_count[i];
			System.out.print(sum_node[i]+" ");
		}
		
		System.out.println();
		System.out.println("\n����������:"+fea_total);
		System.out.println("\n��ϵ������:"+rel_table.get_relation_list().size());
		
		/*����ÿ�������ڹ�ϵ���г��ֵĴ���*/
		for(int i=0;i<rel_table.get_relation_list().size();++i){
		    fea_sum[rel_table.get_relation_list().get(i).get_start()]++;
		    fea_sum[rel_table.get_relation_list().get(i).get_end()]++;
		}
		
		System.out.println("��ͬ�������ֵĴ�����:");
		
		for(int j=0;j<fea_sum_count;++j){
			if(j!=0 && j%4==0)
				System.out.print("\n");
			System.out.print(fea_sum[j]+"��"+" ");
		}
		
		System.out.print("\n\n\n");
	}

	
	/**
	 * �÷�������������ʵĺ���
	 * @param sub �����±�
	 * @return  ������� cp
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public float c_probability(int sub){
		float cp = 0;
		cp=(float)fea_sum[sub]/63;
		return cp;
	}

	
	/**
	 * �÷����Ǽ����������ʵĺ��������Ǽ�����������֮�����������
	 * @param sub1 �����±�1
	 * @param sub2 �����±�2
	 * @param n1    �ڵ�1
	 * @param n2    �ڵ�2
	 * @param rel_tab ��ϵ��
	 * @return ��������
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public float p_probability(int sub1,int sub2,Node n1,Node n2,Relation_table rel_tab){
		float pp=0;
		int frequency1,frequency2;
		frequency1=0;
		frequency2=0;
		
		/*ͨ��forѭ���ж��±������������ֵ*/
		for(int i=0;i<rel_tab.get_relation_list().size();++i){
			
			if(n1.get_node_num()==rel_tab.get_relation_list().get(i).get_node_num1() &&
			   n2.get_node_num()==rel_tab.get_relation_list().get(i).get_node_num2()){
				
				if(sub1==rel_tab.get_relation_list().get(i).get_start())
					frequency1++;
				
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
	
	
	/**
	 * �÷����������������ʺ������������Ϣ�ĺ���
	 * @param n1 �ڵ�1
	 * @param n2 �ڵ�2
	 * @return ��������ʾ�Ļ���Ϣ
	 * @author tang
	 * @Time  2014-05-27
	 */	
	public float mutual_info(Node n1, Node n2){
		int subs1,subs2;
		float p1,p2,p3;
		float val=0;
		for(int i=0;i<n1.get_feature_count();++i){
			subs1=n1.get_node_num()*10+i;
			p1=c_probability(subs1);
			
			for(int j=0;j<n2.get_feature_count();++j){
				subs2=n2.get_node_num()*10+j;
				p2=c_probability(subs2);
				p3=p_probability(subs1,subs2,n1,n2,rel_table);
				
				if(p1!=0 && p2!=0 && p3!=0){
				    val+=(float) ((p1*p3)*Math.log10((p1*p3)/(p1*p2)));
				}
				
			}
		}
		return val;
	}

	
	/**
	 * �÷�����Drating�����������û���Ϣ��������ͼ
	 * @param graph ͼ��
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public void drafting(Graph graph){//drafting����
		float temp_mutual;
		for(int i=0;i<node_count;++i){
			for(int j=0;j<node_count;++j){//����forѭ������ÿ���ڵ�
				
				if(i!=j){//�ڵ㲻��������
					temp_mutual=mutual_info(node_list.get(i),node_list.get(j));
					if(temp_mutual>threshold){
						s_class.add_node_pair(node_list.get(i), node_list.get(j), temp_mutual);
					}
				}	
				
			}
		}
		
        
		s_class.sort_lst();
		System.out.println("������ֵ�ĸ����ڵ�֮��Ļ���Ϣ��:");
		s_class.print_info();
		
		int nm1,nm2;
		System.out.println("\n\ns_class.get_nodepair_list().size() = "+s_class.get_nodepair_list().size());
		for(int i=0;i<s_class.get_nodepair_list().size();++i){
			nm1=s_class.get_nodepair_list().get(i).get_node_num1();
			nm2=s_class.get_nodepair_list().get(i).get_node_num2();

			if(graph.is_path(nm1, nm2)){
				r_class.add_node_pair(s_class.get_nodepair_list().get(i));
			}else{
				graph.add_edge(nm1,nm2);
				graph.add_edge1(nm1,nm2);
			}

		}
		
		System.out.println();
		System.out.print("\n����ͼ�ǣ�");
		graph.print_digraph();
		System.out.print("\nwwww��ͼ�ǣ�");
		graph.print_graph();
		System.out.print("\n\n\n");
		
	}

	
	/**
	 * �����������������������ڲ��ԣ�û��������;
	 * @param args �ղ�
	 * @author tang
	 * @Time 2014-05-27
	 */	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);//����һ������ɨ�������
		System.out.print("������ڵ����[node_count]:");
			node_count=input.nextInt();   
		if(node_count<=0||node_count>100 ){
			System.out.print("Input error in node_count!");
			System.exit(0);
		}
		System.out.print("��������ڱߵ�����[rand1]:");
			rand1=input.nextInt();    
		System.out.print("������ڵ�ÿ�����е���������fea_count[]����С��node_count��ֵ��ͬ������"+node_count+"��:");
			for(int i=0;i<node_count;i++)fea_count[i]=input.nextInt();    
		System.out.print("������ڵ���ϵ����fea_rel_count[],��С��rand1��ֵ��ͬ������"+rand1+"��:");
			for(int i=0;i<rand1;i++)fea_rel_count[i]=input.nextInt();    

		Graph graph=new Graph(node_count);
		Thickening thick=new Thickening();//��ʼ��thick������
		Thinning thin=new Thinning();
		Parameter para=new Parameter();
		Drawing drawing=new Drawing();
		System.out.println("\n\n******************�����������*******************");
		drawing.init_node();
		drawing.print_node();
		drawing.init_rel_table();
		drawing.print_rel_table();
		System.out.println("******************�ɻ������ݵõ��Ĳ���*******************");
		drawing.data_preparation();
		System.out.println("****************�����㷨֮��õ��Ľ��������****************");
		drawing.drafting(graph);
		System.out.println("****************�����㷨֮��õ��Ľ��������****************");
		graph=thick.thicken(graph,node_list,r_class);
		System.out.print("\n�������ͼ�ǣ�");
		graph.print_digraph();
		System.out.print("\n\n\n");
		System.out.println("****************�����㷨֮��õ��Ľ��������****************");
		para.parameter(graph, fea_total, sum_node, node_list, rel_table, fea_sum);
		System.out.print(fea_total+" "+sum_node[0]+" "+fea_sum[0]+" "+node_list.get(0).get_node_num()+" "+node_list.size()+" "+rel_table.get_rel_count());//+rel_table+
		System.out.println("��ȡ�����еĽڵ��·��");
		Ser_recommend ser=new Ser_recommend();
		ser.ser_recommend(graph, node_list, rel_table);
	}

}
