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

public class FixMDReqGrp
{

	public int noMDEntryTypes;
	public MDReqGrp[] group;

	public void getAll(int noMDEntryTypes, ByteBuffer buf) throws FixSessionException {
		this.noMDEntryTypes = noMDEntryTypes;

		if (noMDEntryTypes < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noMDEntryTypes ).getBytes(), FixTags.NOMDENTRYTYPES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noMDEntryTypes) {
			group = new MDReqGrp[noMDEntryTypes];

			for ( int i = 0; i < noMDEntryTypes; i++ ) group[i] = new MDReqGrp();
	}

		for ( int i = 0; i < noMDEntryTypes; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noMDEntryTypes; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noMDEntryTypes; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noMDEntryTypes; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noMDEntryTypes; i++)
			s += group[i].toString();
		return s;
	}

public class MDReqGrp implements FixComponent
{

	public byte mDEntryType = (byte)' ';

	public MDReqGrp() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		mDEntryType = Byte.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.MDENTRYTYPE_INT) {
				mDEntryType = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.MDEntryType.isValid(mDEntryType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + mDEntryType + ") for tag").getBytes(), id, new byte[0] );
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

		if (! FixUtils.isSet(mDEntryType) ) return FixTags.MDENTRYTYPE_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.MDENTRYTYPE_INT, mDEntryType );
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

			 s += "MDEntryType(269)=" + String.valueOf(mDEntryType) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MDReqGrp)) return false;

			MDReqGrp msg = (MDReqGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( mDEntryType==msg.mDEntryType)) return false;

		return true;
	}
}
}
