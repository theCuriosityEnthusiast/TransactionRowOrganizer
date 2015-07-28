import java.util.*;


public class TrackingRowManip{
	
	TrackingRow tr[] = new TrackingRow[3];
	
	List<TrackingRow> trackerList = new ArrayList<TrackingRow>();
	
	public ArrayList<TrackingRow> insert(int start,int end,char status, int transfer){
		
		if(trackerList.size()==0)
		{
			trackerList.insert();
		}
		else
		{
			trackerList.insert();
		}
		
		return trackerList;
	}
	
	
	public TrackingRow[] update_trackingrow(TrackingRow old, TrackingRow neo){
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.SUPERSET){
			old.deleted = true;
			tr[0] = neo;
		}
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.SUBSET){
			tr[0] = new TrackingRow(old.newRange.lo, neo.newRange.lo-1, old.statusCode, old.transferCode);
			tr[1] = new TrackingRow(neo.newRange.lo, neo.newRange.hi, neo.statusCode, neo.transferCode);
			tr[2] = new TrackingRow(neo.newRange.hi+1, old.newRange.hi, old.statusCode, old.transferCode);
		}
		
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.LESSOVERLAP){
			old.deleted = true;
			tr[0] = new TrackingRow(neo.newRange.lo,neo.newRange.hi,neo.statusCode,neo.transferCode);
			tr[1] = new TrackingRow(neo.newRange.hi+1,old.newRange.hi,old.statusCode,old.transferCode);
			
		}
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.MOREOVERLAP){
			old.deleted = true;
			tr[0] = new TrackingRow(old.newRange.lo, neo.newRange.lo-1, old.statusCode, old.transferCode);
			tr[1] = new TrackingRow(neo.newRange.lo, old.newRange.hi, neo.statusCode, neo.transferCode);
			tr[2] = new TrackingRow(old.newRange.hi+1,neo.newRange.hi, neo.statusCode, neo.transferCode);
		}
	
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.MOREDISJOINT){
			
			tr[0] = new TrackingRow(neo.newRange.lo,neo.newRange.hi,neo.statusCode,neo.transferCode);
			
			
		}
		
		if(neo.newRange.classify(old.newRange) == Range.Relation.LESSDISJOINT){
			old.deleted = true;
			tr[0] = new TrackingRow(neo.newRange.lo,neo.newRange.hi,neo.statusCode,neo.transferCode);
			tr[1] = new TrackingRow(old.newRange.lo,old.newRange.hi,old.statusCode,old.transferCode);
			
		}
	
		if(neo.newRange.classify(old.newRange) == Range.Relation.SAME){
			old.deleted = true;
			tr[0] = new TrackingRow(neo.newRange.lo,neo.newRange.hi,neo.statusCode,neo.transferCode);

		}
	
				
		return tr;
	}

}
