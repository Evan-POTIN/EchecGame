package fr.umontpellier.iut.model;

public abstract class ModelPiece {

    protected Couleurs clr;

    public ModelPiece(Couleurs clr) {
        this.clr = clr;
    }

    public Couleurs getClr() {
        return clr;
    }

    public void test() {
        System.out.println(ModelEchiquier.getEchiquierS().toString());
    }
}
