package com.brillio.firstRestService;

import java.io.Serializable;
import java.util.Objects;

public class MarksId implements Serializable{
    private String sid;

    private String testno;

	public MarksId() {
		super();
	}

	public MarksId(String sid, String testno) {
		super();
		this.sid = sid;
		this.testno = testno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid, testno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarksId other = (MarksId) obj;
		return Objects.equals(sid, other.sid) && Objects.equals(testno, other.testno);
	}

}
