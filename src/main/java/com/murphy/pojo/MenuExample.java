package com.murphy.pojo;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andM_idIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andM_idIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andM_idEqualTo(Integer value) {
            addCriterion("m_id =", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThan(Integer value) {
            addCriterion("m_id >", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThan(Integer value) {
            addCriterion("m_id <", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idIn(List<Integer> values) {
            addCriterion("m_id in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_nameIsNull() {
            addCriterion("m_name is null");
            return (Criteria) this;
        }

        public Criteria andM_nameIsNotNull() {
            addCriterion("m_name is not null");
            return (Criteria) this;
        }

        public Criteria andM_nameEqualTo(String value) {
            addCriterion("m_name =", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotEqualTo(String value) {
            addCriterion("m_name <>", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameGreaterThan(String value) {
            addCriterion("m_name >", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameGreaterThanOrEqualTo(String value) {
            addCriterion("m_name >=", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLessThan(String value) {
            addCriterion("m_name <", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLessThanOrEqualTo(String value) {
            addCriterion("m_name <=", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameLike(String value) {
            addCriterion("m_name like", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotLike(String value) {
            addCriterion("m_name not like", value, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameIn(List<String> values) {
            addCriterion("m_name in", values, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotIn(List<String> values) {
            addCriterion("m_name not in", values, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameBetween(String value1, String value2) {
            addCriterion("m_name between", value1, value2, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_nameNotBetween(String value1, String value2) {
            addCriterion("m_name not between", value1, value2, "m_name");
            return (Criteria) this;
        }

        public Criteria andM_stateIsNull() {
            addCriterion("m_state is null");
            return (Criteria) this;
        }

        public Criteria andM_stateIsNotNull() {
            addCriterion("m_state is not null");
            return (Criteria) this;
        }

        public Criteria andM_stateEqualTo(Integer value) {
            addCriterion("m_state =", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateNotEqualTo(Integer value) {
            addCriterion("m_state <>", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateGreaterThan(Integer value) {
            addCriterion("m_state >", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_state >=", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateLessThan(Integer value) {
            addCriterion("m_state <", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateLessThanOrEqualTo(Integer value) {
            addCriterion("m_state <=", value, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateIn(List<Integer> values) {
            addCriterion("m_state in", values, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateNotIn(List<Integer> values) {
            addCriterion("m_state not in", values, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateBetween(Integer value1, Integer value2) {
            addCriterion("m_state between", value1, value2, "m_state");
            return (Criteria) this;
        }

        public Criteria andM_stateNotBetween(Integer value1, Integer value2) {
            addCriterion("m_state not between", value1, value2, "m_state");
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