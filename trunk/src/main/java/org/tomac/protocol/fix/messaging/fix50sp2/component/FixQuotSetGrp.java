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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUnderlyingInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixQuotEntryGrp;

public class FixQuotSetGrp
{

	public int noQuoteSets;
	public QuotSetGrp[] group;

	public void getAll(int noQuoteSets, ByteBuffer buf) throws FixSessionException {
		this.noQuoteSets = noQuoteSets;

		if (noQuoteSets < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noQuoteSets) 
			group = new QuotSetGrp[noQuoteSets];

		for ( int i = 0; i < noQuoteSets; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noQuoteSets; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noQuoteSets; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noQuoteSets; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noQuoteSets; i++)
			s += group[i].toString();
		return s;
	}

public class QuotSetGrp implements FixComponent
{

	public byte[] quoteSetID;
	public FixUnderlyingInstrument underlyingInstrument;
	public byte[] quoteSetValidUntilTime;
	public long totNoQuoteEntries = 0;
	public boolean lastFragment = false;
	public FixQuotEntryGrp quotEntryGrp;

	public QuotSetGrp() {
		super();

		quoteSetID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		underlyingInstrument = new FixUnderlyingInstrument();
		quoteSetValidUntilTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		quotEntryGrp = new FixQuotEntryGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( quoteSetID, (byte)0 );
		Utils.fill( quoteSetValidUntilTime, (byte)0 );
		totNoQuoteEntries = Long.MAX_VALUE;		
		lastFragment = false;		
		underlyingInstrument.clear();
		quotEntryGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.QUOTESETID_INT) {
				quoteSetID = FixUtils.getTagStringValue(value, quoteSetID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGSYMBOL_INT) {
				underlyingInstrument.getAll(FixTags.UNDERLYINGSYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.QUOTESETVALIDUNTILTIME_INT) {
				quoteSetValidUntilTime = FixUtils.getTagStringValue(value, quoteSetValidUntilTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TOTNOQUOTEENTRIES_INT) {
				totNoQuoteEntries = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LASTFRAGMENT_INT) {
				lastFragment = FixUtils.getTagBooleanValue( value );
				if (!LastFragment.isValid(lastFragment) ) throw new FixSessionException(buf, "Invalid enumerated value(" + lastFragment + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOQUOTEENTRIES_INT) {
				quotEntryGrp.getAll(FixTags.NOQUOTEENTRIES_INT, buf);
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

		if (! FixUtils.isSet(quoteSetID) ) return FixTags.QUOTESETID_INT;
		if (! FixUtils.isSet(totNoQuoteEntries) ) return FixTags.TOTNOQUOTEENTRIES_INT;
		if (! quotEntryGrp.isSet() ) return FixTags.NOQUOTEENTRIES_INT;
		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) return true;
		if (FixUtils.isSet(quoteSetValidUntilTime)) return true;
		if (FixUtils.isSet(lastFragment)) return true;
		if (null) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		FixUtils.putFixTag( out, FixTags.QUOTESETID_INT, quoteSetID, 0, Utils.lastIndexTrim(quoteSetID, (byte)0) );
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) underlyingInstrument.encode( out );
		if (FixUtils.isSet(quoteSetValidUntilTime)) FixUtils.putFixTag( out, FixTags.QUOTESETVALIDUNTILTIME_INT, quoteSetValidUntilTime);
		FixUtils.putFixTag( out, FixTags.TOTNOQUOTEENTRIES_INT, totNoQuoteEntries);
		if (FixUtils.isSet(lastFragment)) FixUtils.putFixTag( out, FixTags.LASTFRAGMENT_INT, lastFragment?(byte)'Y':(byte)'N' );
		quotEntryGrp.encode( out );
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

			 s += "QuoteSetID(302)=" + new String(quoteSetID) + sep;
			if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) s += underlyingInstrument.toString();
			if (FixUtils.isSet(quoteSetValidUntilTime)) s += "QuoteSetValidUntilTime(367)=" + new String(quoteSetValidUntilTime) + sep;
			 s += "TotNoQuoteEntries(304)=" + String.valueOf(totNoQuoteEntries) + sep;
			if (FixUtils.isSet(lastFragment)) s += "LastFragment(893)=" + String.valueOf(lastFragment) + sep;
			 s += quotEntryGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof QuotSetGrp)) return false;

			QuotSetGrp msg = (QuotSetGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( quoteSetID, msg.quoteSetID)) return false;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;

		if (!( totNoQuoteEntries==msg.totNoQuoteEntries)) return false;

		if (!( lastFragment==msg.lastFragment)) return false;

		if (!quotEntryGrp.equals(msg.quotEntryGrp)) return false;

		return true;
	}
}
}
