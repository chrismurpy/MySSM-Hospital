package com.murphy.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChargeProjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeProjExample() {
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

        public Criteria andCharP_idIsNull() {
            addCriterion("charP_id is null");
            return (Criteria) this;
        }

        public Criteria andCharP_idIsNotNull() {
            addCriterion("charP_id is not null");
            return (Criteria) this;
        }

        public Criteria andCharP_idEqualTo(Integer value) {
            addCriterion("charP_id =", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idNotEqualTo(Integer value) {
            addCriterion("charP_id <>", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idGreaterThan(Integer value) {
            addCriterion("charP_id >", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("charP_id >=", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idLessThan(Integer value) {
            addCriterion("charP_id <", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idLessThanOrEqualTo(Integer value) {
            addCriterion("charP_id <=", value, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idIn(List<Integer> values) {
            addCriterion("charP_id in", values, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idNotIn(List<Integer> values) {
            addCriterion("charP_id not in", values, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idBetween(Integer value1, Integer value2) {
            addCriterion("charP_id between", value1, value2, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_idNotBetween(Integer value1, Integer value2) {
            addCriterion("charP_id not between", value1, value2, "charP_id");
            return (Criteria) this;
        }

        public Criteria andCharP_nameIsNull() {
            addCriterion("charP_name is null");
            return (Criteria) this;
        }

        public Criteria andCharP_nameIsNotNull() {
            addCriterion("charP_name is not null");
            return (Criteria) this;
        }

        public Criteria andCharP_nameEqualTo(String value) {
            addCriterion("charP_name =", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameNotEqualTo(String value) {
            addCriterion("charP_name <>", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameGreaterThan(String value) {
            addCriterion("charP_name >", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameGreaterThanOrEqualTo(String value) {
            addCriterion("charP_name >=", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameLessThan(String value) {
            addCriterion("charP_name <", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameLessThanOrEqualTo(String value) {
            addCriterion("charP_name <=", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameLike(String value) {
            addCriterion("charP_name like", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameNotLike(String value) {
            addCriterion("charP_name not like", value, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameIn(List<String> values) {
            addCriterion("charP_name in", values, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameNotIn(List<String> values) {
            addCriterion("charP_name not in", values, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameBetween(String value1, String value2) {
            addCriterion("charP_name between", value1, value2, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_nameNotBetween(String value1, String value2) {
            addCriterion("charP_name not between", value1, value2, "charP_name");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyIsNull() {
            addCriterion("charP_money is null");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyIsNotNull() {
            addCriterion("charP_money is not null");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyEqualTo(Long value) {
            addCriterion("charP_money =", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyNotEqualTo(Long value) {
            addCriterion("charP_money <>", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyGreaterThan(Long value) {
            addCriterion("charP_money >", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyGreaterThanOrEqualTo(Long value) {
            addCriterion("charP_money >=", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyLessThan(Long value) {
            addCriterion("charP_money <", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyLessThanOrEqualTo(Long value) {
            addCriterion("charP_money <=", value, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyIn(List<Long> values) {
            addCriterion("charP_money in", values, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyNotIn(List<Long> values) {
            addCriterion("charP_money not in", values, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyBetween(Long value1, Long value2) {
            addCriterion("charP_money between", value1, value2, "charP_money");
            return (Criteria) this;
        }

        public Criteria andCharP_moneyNotBetween(Long value1, Long value2) {
            addCriterion("charP_money not between", value1, value2, "charP_money");
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