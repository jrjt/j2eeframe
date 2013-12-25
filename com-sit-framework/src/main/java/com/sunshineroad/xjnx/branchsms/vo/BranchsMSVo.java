package com.sunshineroad.xjnx.branchsms.vo;

import java.math.BigDecimal;

public class BranchsMSVo
{

	private BigDecimal id;

	private String action;

	private String prodate;

	private String probrc;

	private Character promode;

	private int splitseq;

	private String oppbrc;

	private String modidate;

	private String teller;

	private Character proflag;

	private Character splitflag;

	private String subsys;

	private String subctrlcode;

	private String acctno;

	public BigDecimal getId()
	{
		return id;
	}

	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		if (action != null)
		{
			this.action = action.trim();
		} else
		{
			this.action = action;
		}
	}

	public String getProdate()
	{
		return prodate;
	}

	public void setProdate(String prodate)
	{
		if (prodate != null)
		{
			this.prodate = prodate.trim();
		} else
		{
			this.prodate = prodate;
		}
	}

	public String getProbrc()
	{
		return probrc;
	}

	public void setProbrc(String probrc)
	{
		if (probrc != null)
		{
			this.probrc = probrc.trim();
		} else
		{
			this.probrc = probrc;
		}

	}

	public Character getPromode()
	{
		return promode;
	}

	public void setPromode(Character promode)
	{
		this.promode = promode;
	}

	public int getSplitseq()
	{
		return splitseq;
	}

	public void setSplitseq(int splitseq)
	{
		this.splitseq = splitseq;
	}

	public String getOppbrc()
	{
		return oppbrc;
	}

	public void setOppbrc(String oppbrc)
	{
		if (oppbrc != null)
		{
			this.oppbrc = oppbrc.trim();
		} else
		{
			this.oppbrc = oppbrc;
		}
	}

	public String getModidate()
	{
		return modidate;
	}

	public void setModidate(String modidate)
	{
		if (modidate != null)
		{
			this.modidate = modidate.trim();
		} else
		{
			this.modidate = modidate;
		}
	}

	public String getTeller()
	{
		return teller;
	}

	public void setTeller(String teller)
	{
		if (teller != null)
		{
			this.teller = teller.trim();
		} else
		{
			this.teller = teller;
		}
	}

	public Character getProflag()
	{
		return proflag;
	}

	public void setProflag(Character proflag)
	{
		this.proflag = proflag;
	}

	public Character getSplitflag()
	{
		return splitflag;
	}

	public void setSplitflag(Character splitflag)
	{
		this.splitflag = splitflag;
	}

	public String getSubsys()
	{
		return subsys;
	}

	public void setSubsys(String subsys)
	{
		if (subsys != null)
		{
			this.subsys = subsys.trim();
		} else
		{
			this.subsys = subsys;
		}
	}

	public String getSubctrlcode()
	{
		return subctrlcode;
	}

	public void setSubctrlcode(String subctrlcode)
	{
		if (subctrlcode != null)
		{
			this.subctrlcode = subctrlcode.trim();
		} else
		{
			this.subctrlcode = subctrlcode;
		}
	}

	public String getAcctno()
	{
		return acctno;
	}

	public void setAcctno(String acctno)
	{
		if (acctno != null)
		{
			this.acctno = acctno.trim();
		} else
		{
			this.acctno = acctno;
		}
	}

}