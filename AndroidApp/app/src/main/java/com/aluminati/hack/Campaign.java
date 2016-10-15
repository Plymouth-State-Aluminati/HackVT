package com.aluminati.hack;

/**
 * Created by Devon on 10/15/2016.
 */
public class Campaign{
    private String id;
    private String title;
    private String target;
    private String current;
    private String desc;
    private String createdAt;
    private String deadline;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The target
     */
    public String getTarget() {
        if (target != null)
        {
            int endIndex = target.lastIndexOf(".");
            if (endIndex != -1)
            {
                return target.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
            }
        }
        return target;
    }

    /**
     *
     * @param target
     * The target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     *
     * @return
     * The current
     */
    public String getCurrent() {
        if (current != null)
        {
            int endIndex = current.lastIndexOf(".");
            if (endIndex != -1)
            {
                return current.substring(0, endIndex); // not forgot to put check if(endIndex != -1)
            }
        }
        return current;
    }

    /**
     *
     * @param current
     * The current
     */
    public void setCurrent(String current) {
        this.current = current;
    }

    /**
     *
     * @return
     * The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     * The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The deadline
     */
    public String getDeadline() {
        return deadline;
    }

    /**
     *
     * @param deadline
     * The deadline
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
