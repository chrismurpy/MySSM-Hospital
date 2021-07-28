package com.murphy.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegisterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRe_idIsNull() {
            addCriterion("re_id is null");
            return (Criteria) this;
        }

        public Criteria andRe_idIsNotNull() {
            addCriterion("re_id is not null");
            return (Criteria) this;
        }

        public Criteria andRe_idEqualTo(Integer value) {
            addCriterion("re_id =", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idNotEqualTo(Integer value) {
            addCriterion("re_id <>", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idGreaterThan(Integer value) {
            addCriterion("re_id >", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_id >=", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idLessThan(Integer value) {
            addCriterion("re_id <", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idLessThanOrEqualTo(Integer value) {
            addCriterion("re_id <=", value, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idIn(List<Integer> values) {
            addCriterion("re_id in", values, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idNotIn(List<Integer> values) {
            addCriterion("re_id not in", values, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idBetween(Integer value1, Integer value2) {
            addCriterion("re_id between", value1, value2, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idNotBetween(Integer value1, Integer value2) {
            addCriterion("re_id not between", value1, value2, "re_id");
            return (Criteria) this;
        }

        public Criteria andRe_idCardIsNull() {
            addCriterion("re_idCard is null");
            return (Criteria) this;
        }

        public Criteria andRe_idCardIsNotNull() {
            addCriterion("re_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andRe_idCardEqualTo(String value) {
            addCriterion("re_idCard =", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardNotEqualTo(String value) {
            addCriterion("re_idCard <>", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardGreaterThan(String value) {
            addCriterion("re_idCard >", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardGreaterThanOrEqualTo(String value) {
            addCriterion("re_idCard >=", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardLessThan(String value) {
            addCriterion("re_idCard <", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardLessThanOrEqualTo(String value) {
            addCriterion("re_idCard <=", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardLike(String value) {
            addCriterion("re_idCard like", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardNotLike(String value) {
            addCriterion("re_idCard not like", value, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardIn(List<String> values) {
            addCriterion("re_idCard in", values, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardNotIn(List<String> values) {
            addCriterion("re_idCard not in", values, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardBetween(String value1, String value2) {
            addCriterion("re_idCard between", value1, value2, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_idCardNotBetween(String value1, String value2) {
            addCriterion("re_idCard not between", value1, value2, "re_idCard");
            return (Criteria) this;
        }

        public Criteria andRe_medicalIsNull() {
            addCriterion("re_medical is null");
            return (Criteria) this;
        }

        public Criteria andRe_medicalIsNotNull() {
            addCriterion("re_medical is not null");
            return (Criteria) this;
        }

        public Criteria andRe_medicalEqualTo(String value) {
            addCriterion("re_medical =", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalNotEqualTo(String value) {
            addCriterion("re_medical <>", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalGreaterThan(String value) {
            addCriterion("re_medical >", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalGreaterThanOrEqualTo(String value) {
            addCriterion("re_medical >=", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalLessThan(String value) {
            addCriterion("re_medical <", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalLessThanOrEqualTo(String value) {
            addCriterion("re_medical <=", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalLike(String value) {
            addCriterion("re_medical like", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalNotLike(String value) {
            addCriterion("re_medical not like", value, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalIn(List<String> values) {
            addCriterion("re_medical in", values, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalNotIn(List<String> values) {
            addCriterion("re_medical not in", values, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalBetween(String value1, String value2) {
            addCriterion("re_medical between", value1, value2, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_medicalNotBetween(String value1, String value2) {
            addCriterion("re_medical not between", value1, value2, "re_medical");
            return (Criteria) this;
        }

        public Criteria andRe_priceIsNull() {
            addCriterion("re_price is null");
            return (Criteria) this;
        }

        public Criteria andRe_priceIsNotNull() {
            addCriterion("re_price is not null");
            return (Criteria) this;
        }

        public Criteria andRe_priceEqualTo(Long value) {
            addCriterion("re_price =", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceNotEqualTo(Long value) {
            addCriterion("re_price <>", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceGreaterThan(Long value) {
            addCriterion("re_price >", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceGreaterThanOrEqualTo(Long value) {
            addCriterion("re_price >=", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceLessThan(Long value) {
            addCriterion("re_price <", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceLessThanOrEqualTo(Long value) {
            addCriterion("re_price <=", value, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceIn(List<Long> values) {
            addCriterion("re_price in", values, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceNotIn(List<Long> values) {
            addCriterion("re_price not in", values, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceBetween(Long value1, Long value2) {
            addCriterion("re_price between", value1, value2, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_priceNotBetween(Long value1, Long value2) {
            addCriterion("re_price not between", value1, value2, "re_price");
            return (Criteria) this;
        }

        public Criteria andRe_phoneIsNull() {
            addCriterion("re_phone is null");
            return (Criteria) this;
        }

        public Criteria andRe_phoneIsNotNull() {
            addCriterion("re_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRe_phoneEqualTo(String value) {
            addCriterion("re_phone =", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneNotEqualTo(String value) {
            addCriterion("re_phone <>", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneGreaterThan(String value) {
            addCriterion("re_phone >", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("re_phone >=", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneLessThan(String value) {
            addCriterion("re_phone <", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneLessThanOrEqualTo(String value) {
            addCriterion("re_phone <=", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneLike(String value) {
            addCriterion("re_phone like", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneNotLike(String value) {
            addCriterion("re_phone not like", value, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneIn(List<String> values) {
            addCriterion("re_phone in", values, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneNotIn(List<String> values) {
            addCriterion("re_phone not in", values, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneBetween(String value1, String value2) {
            addCriterion("re_phone between", value1, value2, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_phoneNotBetween(String value1, String value2) {
            addCriterion("re_phone not between", value1, value2, "re_phone");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceIsNull() {
            addCriterion("re_selfPrice is null");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceIsNotNull() {
            addCriterion("re_selfPrice is not null");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceEqualTo(Integer value) {
            addCriterion("re_selfPrice =", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceNotEqualTo(Integer value) {
            addCriterion("re_selfPrice <>", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceGreaterThan(Integer value) {
            addCriterion("re_selfPrice >", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_selfPrice >=", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceLessThan(Integer value) {
            addCriterion("re_selfPrice <", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceLessThanOrEqualTo(Integer value) {
            addCriterion("re_selfPrice <=", value, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceIn(List<Integer> values) {
            addCriterion("re_selfPrice in", values, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceNotIn(List<Integer> values) {
            addCriterion("re_selfPrice not in", values, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceBetween(Integer value1, Integer value2) {
            addCriterion("re_selfPrice between", value1, value2, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_selfPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("re_selfPrice not between", value1, value2, "re_selfPrice");
            return (Criteria) this;
        }

        public Criteria andRe_sexIsNull() {
            addCriterion("re_sex is null");
            return (Criteria) this;
        }

        public Criteria andRe_sexIsNotNull() {
            addCriterion("re_sex is not null");
            return (Criteria) this;
        }

        public Criteria andRe_sexEqualTo(Integer value) {
            addCriterion("re_sex =", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexNotEqualTo(Integer value) {
            addCriterion("re_sex <>", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexGreaterThan(Integer value) {
            addCriterion("re_sex >", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_sex >=", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexLessThan(Integer value) {
            addCriterion("re_sex <", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexLessThanOrEqualTo(Integer value) {
            addCriterion("re_sex <=", value, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexIn(List<Integer> values) {
            addCriterion("re_sex in", values, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexNotIn(List<Integer> values) {
            addCriterion("re_sex not in", values, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexBetween(Integer value1, Integer value2) {
            addCriterion("re_sex between", value1, value2, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_sexNotBetween(Integer value1, Integer value2) {
            addCriterion("re_sex not between", value1, value2, "re_sex");
            return (Criteria) this;
        }

        public Criteria andRe_ageIsNull() {
            addCriterion("re_age is null");
            return (Criteria) this;
        }

        public Criteria andRe_ageIsNotNull() {
            addCriterion("re_age is not null");
            return (Criteria) this;
        }

        public Criteria andRe_ageEqualTo(Integer value) {
            addCriterion("re_age =", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageNotEqualTo(Integer value) {
            addCriterion("re_age <>", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageGreaterThan(Integer value) {
            addCriterion("re_age >", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_age >=", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageLessThan(Integer value) {
            addCriterion("re_age <", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageLessThanOrEqualTo(Integer value) {
            addCriterion("re_age <=", value, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageIn(List<Integer> values) {
            addCriterion("re_age in", values, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageNotIn(List<Integer> values) {
            addCriterion("re_age not in", values, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageBetween(Integer value1, Integer value2) {
            addCriterion("re_age between", value1, value2, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_ageNotBetween(Integer value1, Integer value2) {
            addCriterion("re_age not between", value1, value2, "re_age");
            return (Criteria) this;
        }

        public Criteria andRe_jobIsNull() {
            addCriterion("re_job is null");
            return (Criteria) this;
        }

        public Criteria andRe_jobIsNotNull() {
            addCriterion("re_job is not null");
            return (Criteria) this;
        }

        public Criteria andRe_jobEqualTo(String value) {
            addCriterion("re_job =", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobNotEqualTo(String value) {
            addCriterion("re_job <>", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobGreaterThan(String value) {
            addCriterion("re_job >", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobGreaterThanOrEqualTo(String value) {
            addCriterion("re_job >=", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobLessThan(String value) {
            addCriterion("re_job <", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobLessThanOrEqualTo(String value) {
            addCriterion("re_job <=", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobLike(String value) {
            addCriterion("re_job like", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobNotLike(String value) {
            addCriterion("re_job not like", value, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobIn(List<String> values) {
            addCriterion("re_job in", values, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobNotIn(List<String> values) {
            addCriterion("re_job not in", values, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobBetween(String value1, String value2) {
            addCriterion("re_job between", value1, value2, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_jobNotBetween(String value1, String value2) {
            addCriterion("re_job not between", value1, value2, "re_job");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeIsNull() {
            addCriterion("re_createTime is null");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeIsNotNull() {
            addCriterion("re_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeEqualTo(Date value) {
            addCriterionForJDBCDate("re_createTime =", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("re_createTime <>", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("re_createTime >", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("re_createTime >=", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeLessThan(Date value) {
            addCriterionForJDBCDate("re_createTime <", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("re_createTime <=", value, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeIn(List<Date> values) {
            addCriterionForJDBCDate("re_createTime in", values, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("re_createTime not in", values, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("re_createTime between", value1, value2, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_createTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("re_createTime not between", value1, value2, "re_createTime");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocIsNull() {
            addCriterion("re_lookDoc is null");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocIsNotNull() {
            addCriterion("re_lookDoc is not null");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocEqualTo(Integer value) {
            addCriterion("re_lookDoc =", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocNotEqualTo(Integer value) {
            addCriterion("re_lookDoc <>", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocGreaterThan(Integer value) {
            addCriterion("re_lookDoc >", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_lookDoc >=", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocLessThan(Integer value) {
            addCriterion("re_lookDoc <", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocLessThanOrEqualTo(Integer value) {
            addCriterion("re_lookDoc <=", value, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocIn(List<Integer> values) {
            addCriterion("re_lookDoc in", values, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocNotIn(List<Integer> values) {
            addCriterion("re_lookDoc not in", values, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocBetween(Integer value1, Integer value2) {
            addCriterion("re_lookDoc between", value1, value2, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andRe_lookDocNotBetween(Integer value1, Integer value2) {
            addCriterion("re_lookDoc not between", value1, value2, "re_lookDoc");
            return (Criteria) this;
        }

        public Criteria andD_idIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andD_idIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andD_idEqualTo(Integer value) {
            addCriterion("d_id =", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idGreaterThan(Integer value) {
            addCriterion("d_id >", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idLessThan(Integer value) {
            addCriterion("d_id <", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idIn(List<Integer> values) {
            addCriterion("d_id in", values, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "d_id");
            return (Criteria) this;
        }

        public Criteria andD_idNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "d_id");
            return (Criteria) this;
        }

        public Criteria andRe_remarkIsNull() {
            addCriterion("re_remark is null");
            return (Criteria) this;
        }

        public Criteria andRe_remarkIsNotNull() {
            addCriterion("re_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRe_remarkEqualTo(String value) {
            addCriterion("re_remark =", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkNotEqualTo(String value) {
            addCriterion("re_remark <>", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkGreaterThan(String value) {
            addCriterion("re_remark >", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("re_remark >=", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkLessThan(String value) {
            addCriterion("re_remark <", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkLessThanOrEqualTo(String value) {
            addCriterion("re_remark <=", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkLike(String value) {
            addCriterion("re_remark like", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkNotLike(String value) {
            addCriterion("re_remark not like", value, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkIn(List<String> values) {
            addCriterion("re_remark in", values, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkNotIn(List<String> values) {
            addCriterion("re_remark not in", values, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkBetween(String value1, String value2) {
            addCriterion("re_remark between", value1, value2, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_remarkNotBetween(String value1, String value2) {
            addCriterion("re_remark not between", value1, value2, "re_remark");
            return (Criteria) this;
        }

        public Criteria andRe_stateIsNull() {
            addCriterion("re_state is null");
            return (Criteria) this;
        }

        public Criteria andRe_stateIsNotNull() {
            addCriterion("re_state is not null");
            return (Criteria) this;
        }

        public Criteria andRe_stateEqualTo(Integer value) {
            addCriterion("re_state =", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateNotEqualTo(Integer value) {
            addCriterion("re_state <>", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateGreaterThan(Integer value) {
            addCriterion("re_state >", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateGreaterThanOrEqualTo(Integer value) {
            addCriterion("re_state >=", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateLessThan(Integer value) {
            addCriterion("re_state <", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateLessThanOrEqualTo(Integer value) {
            addCriterion("re_state <=", value, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateIn(List<Integer> values) {
            addCriterion("re_state in", values, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateNotIn(List<Integer> values) {
            addCriterion("re_state not in", values, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateBetween(Integer value1, Integer value2) {
            addCriterion("re_state between", value1, value2, "re_state");
            return (Criteria) this;
        }

        public Criteria andRe_stateNotBetween(Integer value1, Integer value2) {
            addCriterion("re_state not between", value1, value2, "re_state");
            return (Criteria) this;
        }

        public Criteria andD_nameLike(String value){
            addCriterion("d_name like", value, "d_name");
            return (Criteria) this;
        }

        public Criteria andD_keshiLike(String value){
            addCriterion("d_keshi like", value, "d_keshi");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}