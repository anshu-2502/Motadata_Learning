package AdvanceDSA_Lists_22Feb.collectionsLists.linkedLists;

class Node
{
    protected int data;
    protected Node link;

    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }

    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }

    public void setLink(Node n)
    {
        link = n;
    }

    public void setData(int d)
    {
        data = d;
    }

    public Node getLink()
    {
        return link;
    }

    public int getData()
    {
        return data;
    }
}