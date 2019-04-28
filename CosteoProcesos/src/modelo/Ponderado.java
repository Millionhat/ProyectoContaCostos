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
		double produccionEquivalente[][]=new double [4][4];
		for(int i=0;i<4;i++) {
			produccionEquivalente[0][i]=IIP;
		}
		produccionEquivalente[1][]=
		produccionEquivalente[1][]=
		produccionEquivalente[1][]=
		produccionEquivalente[1][]=
		produccionEquivalente[1][]=
        produccionEquivalente[1][]=
        		
		return produccionEquivalente;
	}
}
