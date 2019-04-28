package modelo;

public class Ponderado {
private double IIP;
	private double UE;
	private double UT;
	
	private double percentMDIIP;
	private double percentMODIIP;
	private double percentCIFIIP;
	
	private double MODUE;
	private double MDUE;
	private double CIFUE;
	
	private double percentMDUT;
	private double percentMODUT;
	private double percentCIFUT;
	
	public Ponderado() {
		
	}
	
	public double flujoFisico() {
		return IIP+UE;
	}
	
	public double[][] produccionEquivalente() {
		double produccionEquivalente[][]=new double [4][3];
		for(int i=0;i<3;i++) {
			produccionEquivalente[0][i]=IIP;
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

		return produccionEquivalente;
	}
}
