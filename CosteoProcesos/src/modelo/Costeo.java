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
	private double CIFStarted;
	private double MDStarted;
	
	private double finished;
	private double percentMODFinished;
	private double percentMDFinished;
	private double percentCIFFinished;
	
	private int PepsOPonderado;
	
	private double[][] produccionEquivalente;
	
	private double[] valoresUnitarios;
	
	public Costeo(double[] info, int PepsOPonderado) {
		this.PepsOPonderado = PepsOPonderado;
		inProcess = info[0];
		percentMDProcess = info[1];
		MDProcess = info[2];
		percentMODProcess = info[3];
		MODProcess = info[4];
		percentCIFProcess = info[5];
		CIFProcess = info[6];
		started = info[7];
		MDStarted = info[8];
		MODStarted = info[9];
		CIFStarted = info[10];
		finished = info[11];
		percentMDFinished = info[12];
		percentMODFinished = info[13];
		percentCIFFinished = info[14];
	}
	public double flujoFisico() {
		return inProcess+started;
	}
	
	public void produccionEquivalente() {
		produccionEquivalente = new double [4][3];
		if(PepsOPonderado==PEPS) {
			produccionEquivalente[0][0]=(1-percentMDProcess)*inProcess;
			produccionEquivalente[0][1]=(1-percentMODProcess)*inProcess;
			produccionEquivalente[0][2]=(1-percentCIFProcess)*inProcess;
		}else if(PepsOPonderado==PONDERADO) {
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
        	for(int j=0;j<3;j++) {
        		produccionEquivalente[3][i]+= produccionEquivalente[j][i];
        	}
        }
	}
	public double[][] getProdEquiv(){
		return produccionEquivalente;
	}
	public void calcularValorUnidad() {
		valoresUnitarios=new double[4];
		if(PepsOPonderado==PEPS) {
			valoresUnitarios[0]= MDStarted/produccionEquivalente[3][0];
			valoresUnitarios[1]=MODStarted/produccionEquivalente[3][1];
			valoresUnitarios[2]=CIFStarted/produccionEquivalente[3][2];
		}else if(PepsOPonderado==PONDERADO) {
			valoresUnitarios[0]= (MDStarted+MDProcess)/produccionEquivalente[3][0];
			valoresUnitarios[1]=(MODStarted+MODProcess)/produccionEquivalente[3][1];
			valoresUnitarios[2]=(CIFStarted+CIFProcess)/produccionEquivalente[3][2];
		}
		valoresUnitarios[3] = valoresUnitarios[0] + valoresUnitarios[1] + valoresUnitarios[2];
	}
	public double[] darValUnitario() {
		return valoresUnitarios;
	}
	
	public double[] darValorAsignado() {
		double[] valores=new double[3];
		if(PepsOPonderado == PEPS) {
			valores[0] = ((MDProcess + MODProcess + CIFProcess) + (produccionEquivalente[0][0] * valoresUnitarios[0])
					+ (produccionEquivalente[0][1] * valoresUnitarios[1]) + 
					(produccionEquivalente[0][2] * valoresUnitarios[2])) + 
					(started * valoresUnitarios[3]);
			valores[1] = (produccionEquivalente[2][0] * valoresUnitarios[0])
					+ (produccionEquivalente[2][1] * valoresUnitarios[1]) + 
					(produccionEquivalente[2][2] * valoresUnitarios[2]);
		}else {
			valores[0] =  ((started + inProcess) * valoresUnitarios[3]);
			valores[1] = (produccionEquivalente[2][0] * valoresUnitarios[0])
					+ (produccionEquivalente[2][1] * valoresUnitarios[1]) + 
					(produccionEquivalente[2][2] * valoresUnitarios[2]);
		}
		valores[2] = valores[0] + valores[1];
		return valores;
	}
}
