class Pair
{
    int e;
    double succ;
    Pair(){};
    Pair(int e, double succ)
    {
        this.e = e;
        this.succ = succ;
    }
}
class Solution 
{
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) 
    {
        ArrayList<Pair> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double succ = succProb[i];
            graph[u].add(new Pair(v, succ));
            graph[v].add(new Pair(u, succ));
        }


        double prob[] = new double[n];
        Arrays.fill(prob, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Collections.reverseOrder((a, b) -> Double.compare(a.succ, b.succ)));
        prob[start] = 1;
        pq.add(new Pair(start, 1));

        while(!pq.isEmpty())
        {
            Pair temp = pq.remove();
            int e = temp.e;
            double succ = temp.succ;

            for(Pair p : graph[e])
            {
                int edge = p.e;
                double succProbabilty = p.succ;

                if(prob[edge] == -1)
                {
                    prob[edge] = prob[e] * succProbabilty;
                    pq.add(new Pair(edge, prob[edge]));
                }
                else
                {
                    if(prob[e] * succProbabilty > prob[edge])
                    {
                        prob[edge] = prob[e] * succProbabilty;
                        pq.add(new Pair(edge, prob[edge]));
                    }
                }
            }
        }
        return (prob[end] == -1) ? 0 : prob[end];
    }
}