 
public class Course
{
    private String crn;
    private String subj;
    private String num;
    private String name;
    private String cap;
    private String days;
    private String time;
    private String instr;
 
//    public Course(String crn, String sub, String num, String name, String cap, String days, String time, String instr)
//    {
//        this.crn = crn;
//        this.sub = sub;
//        this.num = num;
//        this.name = name;
//        this.cap = cap; 
//        this.days = days;
//        this.time = time;
//        this.instr = instr;
//    }
 
    public String getCRN()
    {
        return crn;
    }
 
    public void setCRN(String crn)
    {
        this.crn = crn;
    }
 
    public String getSubj()
    {
        return subj;
    }
 
    public void setSubj(String subj)
    {
        this.subj = subj;
    }
    
    public String getNum()
    {
    	return num;
    }
    
    public void setNum(String num)
    {
    	this.num = num;
    }
    
    public String getName()
    {
        return name;
    }
 
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCap()
    {
        return cap;
    }
 
    public void setCap(String cap)
    {
        this.cap = cap;
    }
    
    public String getDays()
    {
        return days;
    }
 
    public void setDays(String days)
    {
        this.days = days;
    }
    public String getTime()
    {
        return time;
    }
 
    public void setTime(String time)
    {
        this.time = time;
    }
    public String setInstr()
    {
    	return instr;
    }
    
    public void getInstr(String instr)
    {
    	this.instr = instr;
    }
    
}