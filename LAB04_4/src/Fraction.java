public class Fraction {
    public int btmN, topN;
    public void addFraction(Fraction f){
        if (btmN == f.btmN){
            topN = topN + f.topN;
        }
        else{
            topN = topN*f.btmN + f.topN*btmN;
            btmN *= f.btmN;
        }
    }
    
    
    public String toFloat(){
        return ""+(topN / btmN);
    }
    public String toFraction(){
        return topN + "/" + btmN;
    }
}
