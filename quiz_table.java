//package questions_quiz;

import java.sql.Timestamp;

public class quiz_table {
private int tech_id;
private Timestamp quiz_date;

private String q1;
private String a1;
private String opt1a;
private String opt1b;
private String opt1c;
private String opt1d;
private String q2;
private String a2;
private String opt2a;
private String opt2b;
private String opt2c;
private String opt2d;
private String q3;
private String a3;
private String opt3a;
private String opt3b;
private String opt3c;
private String opt3d;
public quiz_table(int  tech_id,String q1,String a1,String opt1a,String opt1b,String opt1c,String opt1d,String q2,String a2,String opt2a,String opt2b,String opt2c,String opt2d,String q3,String a3,String opt3a,String opt3b,String opt3c,String opt3d)
{
	//this.quiz_date=quiz_date;	
	this.tech_id=tech_id;
	this.q1=q1;
	this.a1=a1;
	this.opt1a=opt1a;
	this.opt1b=opt1b;
	this.opt1c=opt1c;
	this.opt1d=opt1d;
	this.q2=q2;
	this.a2=a2;
	this.opt2a=opt2a;
	this.opt2b=opt2b;
	this.opt2c=opt2c;
	this.opt2d=opt2d;
	this.q3=q3;
	this.a3=a3;	
	this.opt3a=opt3a;
	this.opt3b=opt3b;
	this.opt3c=opt3c;
	this.opt3d=opt3d;
}
public String getOpt1a() {
	return opt1a;
}
public void setOpt1a(String opt1a) {
	this.opt1a = opt1a;
}
public String getOpt1b() {
	return opt1b;
}
public void setOpt1b(String opt1b) {
	this.opt1b = opt1b;
}
public String getOpt1c() {
	return opt1c;
}
public void setOpt1c(String opt1c) {
	this.opt1c = opt1c;
}
public String getOpt1d() {
	return opt1d;
}
public void setOpt1d(String opt1d) {
	this.opt1d = opt1d;
}
public String getOpt2a() {
	return opt2a;
}
public void setOpt2a(String opt2a) {
	this.opt2a = opt2a;
}
public String getOpt2b() {
	return opt2b;
}
public void setOpt2b(String opt2b) {
	this.opt2b = opt2b;
}
public String getOpt2c() {
	return opt2c;
}
public void setOpt2c(String opt2c) {
	this.opt2c = opt2c;
}
public String getOpt2d() {
	return opt2d;
}
public void setOpt2d(String opt2d) {
	this.opt2d = opt2d;
}
public String getOpt3a() {
	return opt3a;
}
public void setOpt3a(String opt3a) {
	this.opt3a = opt3a;
}
public String getOpt3b() {
	return opt3b;
}
public void setOpt3b(String opt3b) {
	this.opt3b = opt3b;
}
public String getOpt3c() {
	return opt3c;
}
public void setOpt3c(String opt3c) {
	this.opt3c = opt3c;
}
public String getOpt3d() {
	return opt3d;
}
public void setOpt3d(String opt3d) {
	this.opt3d = opt3d;
}
public Timestamp getQuiz_date() {
	return quiz_date;
}

public void setQuiz_date(Timestamp quiz_date) {
	this.quiz_date = quiz_date;
}
public int getTech_id() {
	return tech_id;
}
public void setTech_id(int tech_id) {
	this.tech_id = tech_id;
}

public String getQ1() {
	return q1;
}
public void setQ1(String q1) {
	this.q1 = q1;
}
public String getA1() {
	return a1;
}
public void setA1(String a1) {
	this.a1 = a1;
}
public String getQ2() {
	return q2;
}
public void setQ2(String q2) {
	this.q2 = q2;
}
public String getA2() {
	return a2;
}
public void setA2(String a2) {
	this.a2 = a2;
}
public String getQ3() {
	return q3;
}
public void setQ3(String q3) {
	this.q3 = q3;
}
public String getA3() {
	return a3;
}
public void setA3(String a3) {
	this.a3 = a3;
}	
}
