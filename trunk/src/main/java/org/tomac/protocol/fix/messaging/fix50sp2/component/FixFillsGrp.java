package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties4;

public class FixFillsGrp
{

	public int noFills;
	public FillsGrp[] group;

	public void getAll(int noFills, ByteBuffer buf) throws FixSessionException {
		this.noFills = noFills;

		if (noFills < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noFills) 
			group = new FillsGrp[noFills];

		for ( int i = 0; i < noFills; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noFills; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noFills; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noFills; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noFills; i++)
			s += group[i].toString();
		return s;
	}

public class FillsGrp implements FixComponent
{

	public byte[] fillExecID;
	public long fillPx = 0;
	public long fillQty = 0;
	public long fillLiquidityInd = 0;
	public FixNestedParties4 nestedParties4;

	public FillsGrp() {
		super();

		fillExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nestedParties4 = new FixNestedParties4();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( fillExecID, (byte)0 );
		fillPx = Long.MAX_VALUE;		
		fillQty = Long.MAX_VALUE;		
		fillLiquidityInd = Long.MAX_VALUE;		
		nestedParties4.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.FILLEXECID_INT) {
				fillExecID = FixUtils.getTagStringValue(value, fillExecID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FILLPX_INT) {
				fillPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FILLQTY_INT) {
				fillQty = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FILLLIQUIDITYIND_INT) {
				fillLiquidityInd = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTED4PARTYIDS_INT) {
				nestedParties4.getAll(FixTags.NONESTED4PARTYIDS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(fillExecID)) return true;
		if (FixUtils.isSet(fillPx)) return true;
		if (FixUtils.isSet(fillQty)) return true;
		if (FixUtils.isSet(fillLiquidityInd)) return true;
		if (FixUtils.isSet(nestedParties4.noNested4PartyIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(fillExecID)) FixUtils.putFixTag( out, FixTags.FILLEXECID_INT, fillExecID, 0, Utils.lastIndexTrim(fillExecID, (byte)0) );
		if (FixUtils.isSet(fillPx)) FixUtils.putFixFloatTag( out, FixTags.FILLPX_INT, fillPx);
		if (FixUtils.isSet(fillQty)) FixUtils.putFixFloatTag( out, FixTags.FILLQTY_INT, fillQty);
		if (FixUtils.isSet(fillLiquidityInd)) FixUtils.putFixTag( out, FixTags.FILLLIQUIDITYIND_INT, fillLiquidityInd);
		if (FixUtils.isSet(nestedParties4.noNested4PartyIDs)) nestedParties4.encode( out );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(fillExecID)) s += "FillExecID(1363)=" + new String(fillExecID) + sep;
			if (FixUtils.isSet(fillPx)) s += "FillPx(1364)=" + String.valueOf(fillPx) + sep;
			if (FixUtils.isSet(fillQty)) s += "FillQty(1365)=" + String.valueOf(fillQty) + sep;
			if (FixUtils.isSet(fillLiquidityInd)) s += "FillLiquidityInd(1443)=" + String.valueOf(fillLiquidityInd) + sep;
			if (FixUtils.isSet(nestedParties4.noNested4PartyIDs)) s += nestedParties4.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FillsGrp)) return false;

			FillsGrp msg = (FillsGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( fillExecID, msg.fillExecID)) return false;

		if (!( fillPx==msg.fillPx)) return false;

		if (!( fillQty==msg.fillQty)) return false;

		if (!( fillLiquidityInd==msg.fillLiquidityInd)) return false;

		if (!nestedParties4.equals(msg.nestedParties4)) return false;

		return true;
	}
}
}
