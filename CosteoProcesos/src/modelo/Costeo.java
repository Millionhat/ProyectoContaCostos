package modelo;

public class Costeo {

	public static final int PEPS=0;
	public static final int PONDERADO=1;

	private double inProcess;
	private double MODProcess;
	private double CIFProcess;
	private double MDProcess;
	private double percentMODProcess;
	private double percentMDProcess;
	private double percentCIFProcess;
	
	private double started;
	private double MODStarted;
	private double CIFstarted;
	private double MDStarted;
	
	private double finished;
	private double MODSFinished;
	private double CIFFinished;
	private double MDFinished;
	private double percentMODFinished;
	private double percentMDFinished;
	private double percentCIFinished;
	
	private int PepsOPonderado;
	
	
	public Costeo() {
		
	}
	public double flujoFisico() {
		return inProcess+started;
	}
	
	public void produccionEquivalente() {
		double produccionEquivalente[][]=new double [4][3];
		if(PepsOPonderado==PEPS) {
			produccionEquivalente[0][0]=(1-percentMDProcess)*inProcess;
			produccionEquivalente[0][1]=(1-percentMODProcess)*inProcess;
			produccionEquivalente[0][2]=(1-percentCIFProcess)*inProcess;
		}else if(PepsOPonderado==PONDERADO) {
			for(int i=0;i<3;i++) {
				produccionEquivalente[0][i]=started;
			}
		}
		produccionEquivalente[1][0]=
		produccionEquivalente[1][1]=
		produccionEquivalente[1][2]=
		produccionEquivalente[2][0]=
		produccionEquivalente[2][1]=
        produccionEquivalente[2][2]=
        produccionEquivalente[3][0]=
        produccionEquivalente[3][1]=
        produccionEquivalente[3][2]=

		
	}
}
