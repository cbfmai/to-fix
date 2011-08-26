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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixContAmtGrp
{

	public int noContAmts;
	public ContAmtGrp[] group;

	public void getAll(int noContAmts, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noContAmts = noContAmts;

		if (noContAmts < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noContAmts ).getBytes(), FixTags.NOCONTAMTS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noContAmts) {
			group = new ContAmtGrp[noContAmts];

			for ( int i = 0; i < noContAmts; i++ ) group[i] = new ContAmtGrp();
	}

		for ( int i = 0; i < noContAmts; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noContAmts; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noContAmts; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noContAmts; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noContAmts; i++)
			s += group[i].toString();
		return s;
	}

public class ContAmtGrp implements FixComponent
{

	public long contAmtType = 0;
	public long contAmtValue = 0;
	public byte[] contAmtCurr;

	public ContAmtGrp() {
		super();

		contAmtCurr = new byte[FixUtils.CURRENCY_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		contAmtType = Long.MAX_VALUE;		
		contAmtValue = Long.MAX_VALUE;		
		Utils.fill( contAmtCurr, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.CONTAMTTYPE_INT) {
				contAmtType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.ContAmtType.isValid(contAmtType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + contAmtType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CONTAMTVALUE_INT) {
				contAmtValue = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CONTAMTCURR_INT) {
				contAmtCurr = FixUtils.getTagStringValue(value, contAmtCurr);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		if (FixUtils.isSet(contAmtType)) return true;
		if (FixUtils.isSet(contAmtValue)) return true;
		if (FixUtils.isSet(contAmtCurr)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(contAmtType)) FixUtils.putFixTag( out, FixTags.CONTAMTTYPE_INT, contAmtType);
		if (FixUtils.isSet(contAmtValue)) FixUtils.putFixFloatTag( out, FixTags.CONTAMTVALUE_INT, contAmtValue);
		if (FixUtils.isSet(contAmtCurr)) FixUtils.putFixTag( out, FixTags.CONTAMTCURR_INT, contAmtCurr, 0, Utils.lastIndexTrim(contAmtCurr, (byte)0) );
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

			if (FixUtils.isSet(contAmtType)) s += "ContAmtType(519)=" + String.valueOf(contAmtType) + sep;
			if (FixUtils.isSet(contAmtValue)) s += "ContAmtValue(520)=" + String.valueOf(contAmtValue) + sep;
			if (FixUtils.isSet(contAmtCurr)) s += "ContAmtCurr(521)=" + new String(contAmtCurr) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ContAmtGrp)) return false;

			ContAmtGrp msg = (ContAmtGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( contAmtType==msg.contAmtType)) return false;

		if (!( contAmtValue==msg.contAmtValue)) return false;

		if (!Utils.equals( contAmtCurr, msg.contAmtCurr)) return false;

		return true;
	}
}
}
