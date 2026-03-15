class Fancy {
    List<Long> seq = new ArrayList<>();
    long mul = 1;
    long add = 0;
    long ma = 1000000007;

    long power(long a, long b){
        if(b==0) return 1;
        long half = power(a, b/2);
        long result = (half * half) % ma;
        if(b%2 == 1){
            result =( result * a )% ma;
        }
        return result;
    }
    
    public Fancy() {
        
    }
    
    public void append(int val) {
        long x = ((val - add) % ma +ma) * power(mul , ma -2) % ma;
        seq.add(x);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % ma;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % ma;
        add = (add * m) % ma;
    }
    
    public int getIndex(int idx) {
        if(idx >= seq.size()) return -1;

        return (int)((seq.get(idx) * mul + add) % ma);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */