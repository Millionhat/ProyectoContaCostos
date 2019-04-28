package modelo;

public class Costeo {
	public static final int PEPS=0;
	public static final int PONDERADO=0;
	
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
	private double percentMODStarted;
	private double percentMDStarted;
	private double percentCIFStarted;
	
	private double finished;
	private double MODSFinished;
	private double CIFFinished;
	private double MDFinished;
	private double percentMODFinished;
	private double percentMDFinished;
	private double percentCIFFinished;
	
	private int pepsOPonderado;
	
	private double[][] produccionEquivalente;
	public Costeo() {
		
	}
	public double flujoFisico() {
		return inProcess+started;
	}
	
	public void produccionEquivalente() {
		produccionEquivalente=new double [4][3];
		if(pepsOPonderado==PEPS) {
		produccionEquivalente[0][0]=(1-percentMDProcess)*inProcess;
		produccionEquivalente[0][1]=(1-percentMODProcess)*inProcess;
		produccionEquivalente[0][2]=(1-percentCIFProcess)*inProcess;
		}else if(pepsOPonderado==PONDERADO) {
			for(int i=0;i<3;i++) {
				produccionEquivalente[0][i]=inProcess;
			}
		}
		produccionEquivalente[1][0]=started;
		produccionEquivalente[1][1]=started;
		produccionEquivalente[1][2]=started;
		produccionEquivalente[2][0]=percentMDFinished*finished;		
		produccionEquivalente[2][1]=percentMODFinished*finished;
        produccionEquivalente[2][2]=percentCIFFinished*finished;
        for(int i=0;i<3;i++) {
        	for (int j=0; j<3;j++){
               produccionEquivalente[3][i]+=produccionEquivalente[j][i];
        	}
        }
	}
	
	public double[][] darPE(){
		return produccionEquivalente;
	}
	
	public 
	
}
