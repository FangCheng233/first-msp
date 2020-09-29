package com.fc.msp.response;

/**
 * @ClassName EdgesData
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/20 5:16 下午
 * @Version 1.0
 */
public class EchartsData {
    private boolean fixed;
    private int x;
    private int y;
    private int symbolSize;
    private String name;
    private String id;
    private String target;
    private String type;

    transient static final int X = 400;
    transient static final int Y = 200;
    transient static final boolean FIXED = true;
    public EchartsData(boolean fixed, int x, int y, int symbolSize, String name, String id, String target, String type) {
        this.fixed = fixed;
        this.x = x;
        this.y = y;
        this.symbolSize = symbolSize;
        this.name = name;
        this.id = id;
        this.target = target;
        this.type = type;
    }

    public EchartsData(int symbolSize, String name, String id, String target, String type) {
        this(FIXED,X,Y,symbolSize,name,id,target,type);
    }

    /**
     * Gets the value of x. *
     *
     * @return the value of x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x. *
     * <p>You can use getX() to get the value of x</p>
     * * @param x x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the value of y. *
     *
     * @return the value of y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y. *
     * <p>You can use getY() to get the value of y</p>
     * * @param y y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the value of fixed. *
     *
     * @return the value of fixed
     */
    public boolean getFixed() {
        return fixed;
    }

    /**
     * Sets the fixed. *
     * <p>You can use getFixed() to get the value of fixed</p>
     * * @param fixed fixed
     */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }


    /**
     * Gets the value of symbolSize. *
     *
     * @return the value of symbolSize
     */
    public int getSymbolSize() {
        return symbolSize;
    }

    /**
     * Sets the symbolSize. *
     * <p>You can use getSymbolSize() to get the value of symbolSize</p>
     * * @param symbolSize symbolSize
     */
    public void setSymbolSize(int symbolSize) {
        this.symbolSize = symbolSize;
    }

    /**
     * Gets the value of name. *
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name. *
     * <p>You can use getName() to get the value of name</p>
     * * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of id. *
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id. *
     * <p>You can use getId() to get the value of id</p>
     * * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the value of target. *
     *
     * @return the value of target
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the target. *
     * <p>You can use getTarget() to get the value of target</p>
     * * @param target target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Gets the value of type. *
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type. *
     * <p>You can use getType() to get the value of type</p>
     * * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EchartsData{" +
                "fixed=" + fixed +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", symbolSize='" + symbolSize + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", target='" + target + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
