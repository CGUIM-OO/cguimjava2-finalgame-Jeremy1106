import java.util.ArrayList;

public class Player_B0444251 extends Player {
	
	
	
    private  int  calculate8 =0;
    private  int  calculate5 =0;
    private  int  calculate3=0;//ӛ�ƵĔ���
 
	
	 int nDeck;//�м�����
	 int curcle =1;//makebet���ñ���


	
	public Player_B0444251( int chips) {
		super("Tianshuo B0444251", chips);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int make_bet() {//����122��ע����
		if (curcle ==1){
			setBet(100);
			curcle ++;
		}
		if(curcle ==2)
		{
			setBet(200);
			curcle ++;
		}
		if(curcle ==3)
		{
			setBet(200);
			curcle -=2;//�������������һѭ��
		}
		if (getBet() <= get_current_chips()) {//������ͷ��ʼ
			return getBet();
		} else {
			setBet(0);
			return getBet();
		}
	

		// TODO Auto-generated method stub
	}

	@Override
	public boolean hit_me(Table table) {
		boolean anshan =false;
		nDeck=table.getNumberOfDeck();//��ȡ��������
		ArrayList<Card> openCard;
		openCard =table.getOpenedCards();
		for(Card c: openCard)//�����������ƽ�������
		{
			if(c.getRank()>=9)
				calculate8 --;
			else if(c.getRank()<=8 &&c.getRank()>=2)
				calculate8 ++;
			if(c.getRank()>=6)
				calculate5 --;
			else if(c.getRank()<=5 &&c.getRank()>=2)
				calculate5 ++;
			if(c.getRank()>=4)
				calculate3 --;
			else if(c.getRank()<=3 &&c.getRank()>=2)
				calculate3 ++;
		}
		if(table.getPercentofUsedCard()>0.5)//������50%�Ʒ�����ʼִ�У���Ϊ��ʱcaculate��ʼ���׼ȷ
		{
		
		
		int [] a=table.get_palyers_bet();
		
		int TotalValue = getTotalValue();
		
		if(TotalValue <=11)//�oՓ�Εr11���¶�Ҫ��
			{
			anshan = true;
			}
	     if(TotalValue <= 14 &&TotalValue>=12)
		{
			anshan = situationbig(calculate8);
		}
	     if(TotalValue <= 16 &&TotalValue>=15)
			{
				anshan = situationmid(calculate5);
			}
		
		
		 if(TotalValue <= 18 &&TotalValue>=17)
		{
			anshan = situationsmall(calculate3);
			
		}if(TotalValue >18)
		{
			anshan = false;
		}
		}
		else{
			int total_value = getTotalValue();

			if (total_value >= 17) {
				anshan = false;
			} else {
				anshan = true;
			}

			
		}
		return anshan;
		
			 
			
			
			
			
					
			
		
		
		
		// TODO Auto-generated method stub

	}
	public  boolean situationbig(int caculation)//x��Ҫ����ʱ����
	{
		if (caculation <-5*nDeck)
			return false;
		else 
			return true;
			
		
	}
	public  boolean situationmid(int caculation)//��Ҫ�е���ʱ����
	{
		if (caculation <-5*nDeck)
			return false;
		else 
			return true;
			
		
	}
	
	public  boolean situationsmall(int caculation)//��ҪС��ʱ����
	{
		if (caculation <-5*nDeck)
			return false;
		else 
			return true;
			
		
	}

	

}
