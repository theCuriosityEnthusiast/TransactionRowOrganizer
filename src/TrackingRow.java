import java.util.*;

public class TrackingRow {
	
	public int transferCode;
	public char statusCode;
	public Range newRange;
	public boolean deleted;
	
	TrackingRow(int start, int end, char statusCode, int transferCode){
		newRange = new Range();
		this.transferCode = transferCode;
		this.statusCode = statusCode;
		newRange.hi = end;
		newRange.lo = start;
		deleted = false;
	}
	
	TrackingRow(){
		newRange = new Range();
		this.transferCode = 0;
		this.statusCode = ' ';
		newRange.hi = Integer.MAX_VALUE;
		newRange.lo = -1;
		deleted = false;
	}
	
	}
